package com.nico.oauth.controller;

import com.nico.common.constant.RedisConstants;
import com.nico.common.utils.JwtUtils;
import com.nico.common.utils.StringUtils;
import com.nico.common.web.domain.AjaxResult;
import com.nico.oauth.domain.Account;
import com.nico.oauth.param.LoginParam;
import com.nico.oauth.param.RegisterParam;
import com.nico.oauth.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class OauthController {


    @Autowired
    private OauthService oauthService;

    @Autowired
    private RedisTemplate redisTemplate;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public AjaxResult login( @RequestBody @Validated LoginParam loginParam){

        //1、通过数据库查询用户信息
        Account account =  oauthService.selectAccountByAccountName(loginParam.getAccountName());

        //2、判断用户是否存在
        if (StringUtils.isNull(account)){
            return AjaxResult.error("用户不存在");
        }

        //3、加密登录密码


        //4、比较密码是否正确
        if (!bCryptPasswordEncoder.matches(loginParam.getPassword(), account.getPassword())) {
            return AjaxResult.error("密码错误");
        }


        //5、获取权限和角色
        List<String> roles = oauthService.selectRoleByAccountId(account.getAccountId());
        List<String> permissions = oauthService.selectPermissionByAccountId(account.getAccountId());

        //6、生成token并返回
        String token = JwtUtils.createToken(account.getAccountId(), roles, permissions);

        //7、将token保存到redis中(30分钟)
        String key = RedisConstants.TOKENPREFIX + account.getAccountId();
        redisTemplate.opsForValue().set(key, token, JwtUtils.EXPIRE, TimeUnit.MILLISECONDS);


        return AjaxResult.success("登录成功").put("token", token);

    }

    @PostMapping("/logout")
    public AjaxResult logout(){

        //1、通过token获取用户id
        long accountId = JwtUtils.getAccountId();

        //2、删除token
        String key = RedisConstants.TOKENPREFIX + accountId;
        redisTemplate.delete(key);

        //3、返回
        return AjaxResult.success("退出登录成功");
    }


    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Validated RegisterParam registerParam){


        //1、查看该用户名是否存在
        Account account = oauthService.selectAccountByAccountName(registerParam.getAccountName());
        if (StringUtils.isNotNull(account)){
            return AjaxResult.error("用户名已存在");
        }

        //2、加密原密码
//        String encryptionPassword = DigestUtils.md5Hex(registerParam.getPassword());
        String encryptionPassword = bCryptPasswordEncoder.encode(registerParam.getPassword());


        //3、复制对象
        account = new Account();
        account.setAccountName(registerParam.getAccountName());
        account.setPassword(encryptionPassword);

        account.setDelFlag(0);

        //4、插入数据库
        int insert = oauthService.insertAccount(account);


        //5、返回结果
        if (insert > 0){
            return AjaxResult.success("注册成功");
        }else{
            return AjaxResult.error("注册失败");
        }

    }





}
