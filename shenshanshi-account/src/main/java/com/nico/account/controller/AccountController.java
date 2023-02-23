package com.nico.account.controller;

import com.nico.common.domain.Account;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/account")
    public AjaxResult getAccount(){

        Account account = new Account();
        account.setAccountId(123456L);
        return AjaxResult.success(account);
    }


    @GetMapping("/account/{accountId}")
    public AjaxResult getAccount(@PathVariable Long accountId){
        Account account = new Account();
        account.setAccountId(123456L);
        return AjaxResult.success(account);
    }


    @GetMapping("/accounts")
    public AjaxResult getAccounts(){

        Account account = new Account();
        account.setAccountId(123456L);
        List list = new ArrayList();
        list.add(account);
        return AjaxResult.success(list);
    }


    @DeleteMapping("/account")
    public AjaxResult deleteAccount(){
        return AjaxResult.success("删除成功");
    }




}
