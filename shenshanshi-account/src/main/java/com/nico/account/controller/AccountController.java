package com.nico.account.controller;

import com.nico.common.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/account")

    public AjaxResult account(){
        return AjaxResult.success("hello nico!");
    }


    @GetMapping("test")
    public AjaxResult test(){
        return AjaxResult.success("test");
    }


}
