package com.nico.oauth.controller;

import com.nico.common.param.LoginParam;
import com.nico.common.param.RegisterParam;
import com.nico.common.utils.JwtUtils;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {

    @PostMapping("/login")
    public AjaxResult login( @RequestBody @Validated LoginParam loginParam){

        String token = JwtUtils.createToken(123L);

        return AjaxResult.success("登录成功").put("token", token);
    }

    @PostMapping("/logout")
    public AjaxResult logout(){
        return AjaxResult.success("退出登录成功");
    }


    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Validated RegisterParam registerParam){




        return AjaxResult.success("注册成功");
    }





}
