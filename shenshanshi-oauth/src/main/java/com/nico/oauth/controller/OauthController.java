package com.nico.oauth.controller;

import com.nico.common.param.LoginParam;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {

    @PostMapping("/login")
    public AjaxResult login(@Validated @RequestBody LoginParam loginParam){




        return AjaxResult.success("登录成功");
    }


}
