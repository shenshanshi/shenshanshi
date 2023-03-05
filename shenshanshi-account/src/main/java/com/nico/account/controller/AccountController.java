package com.nico.account.controller;


import com.nico.account.domain.Account;
import com.nico.account.service.AccountService;
import com.nico.common.annotation.RequiresLogin;
import com.nico.common.utils.ImageUtils;
import com.nico.common.utils.JwtUtils;
import com.nico.common.utils.StringUtils;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/account/account")
public class AccountController {

    @Resource
    private AccountService accountService;




    /**
     * 查询 根据主键 id 查询
     * @author nico
     * @date 2023/02/26
     **/
    @GetMapping
    @RequiresLogin
    public AjaxResult getAccount(){
        long accountId = JwtUtils.getAccountId();

        Account account = accountService.selectAccountByAccountId(accountId);

        account.setAvatar(ImageUtils.getAvatarURL(account.getAvatar()));

        return AjaxResult.success(account);
    }


    @GetMapping("/{accountId}")
    public AjaxResult getAccount(@PathVariable Long accountId){
        Account account = accountService.selectAccountByAccountId(accountId);

        if (StringUtils.isNull(account)){
            return AjaxResult.error();
        }
        account.setAvatar(ImageUtils.getAvatarURL(account.getAvatar()));
        return AjaxResult.success(account);
    }


    /**
     * 新增
     * @author nico
     * @date 2023/02/26
     **/
    @PostMapping
    public AjaxResult insert(@RequestBody Account account){

        if (StringUtils.isNull(account))
            return AjaxResult.error();

        int insert = accountService.insertAccount(account);
        if (insert > 0){
            return AjaxResult.success();
        }

        return AjaxResult.error();

    }

    /**
     * 刪除
     * @author nico
     * @date 2023/02/26
     **/
    @DeleteMapping
    public AjaxResult delete(Long id){
        int delete = accountService.deleteAccount(id);
        return AjaxResult.success(delete);
    }

    /**
     * 更新
     * @author nico
     * @date 2023/02/26
     **/
    @PutMapping
    public AjaxResult update(Account account){
        accountService.updatAccount(account);

        return AjaxResult.success();
    }



    /**
     * 查询 分页查询
     * @author nico
     * @date 2023/02/26
     **/
    @GetMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return accountService.pageList(offset, pagesize);
    }

}