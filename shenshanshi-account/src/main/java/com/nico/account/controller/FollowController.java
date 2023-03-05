package com.nico.account.controller;

import com.nico.account.domain.Follow;
import com.nico.account.service.FollowService;
import com.nico.common.annotation.RequiresLogin;
import com.nico.common.utils.JwtUtils;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/test")
    public AjaxResult test(){
        return AjaxResult.success("测试成功");
    }

    @PostMapping
    public AjaxResult follow(@RequestBody @Validated Follow follow){

        int in = followService.insertFollow(follow);
        return AjaxResult.success(in);

    }

    @DeleteMapping
    public AjaxResult deleteFollow(@RequestBody @Validated Follow follow){

        int deleteFollow = followService.deleteFollow(follow);
        return AjaxResult.success(deleteFollow);

    }


    @GetMapping("/recommend")
    @RequiresLogin
    public AjaxResult recommend(){
        long accountId1 = JwtUtils.getAccountId();
        List<Follow> recommend = followService.recommend(accountId1);
        return AjaxResult.success(recommend);


    }


}
