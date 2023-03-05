package com.nico.forum.controller;

import com.alibaba.fastjson2.JSON;
import com.nico.common.web.domain.AjaxResult;
import com.nico.forum.domain.Post;
import com.nico.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/forum/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/{postId}")
    public AjaxResult getPost(@PathVariable Long postId){
        Post post = postService.selectPostById(postId);

        return AjaxResult.success(post);
    }

    @GetMapping("/recommend")
    public AjaxResult recommend(){
        List<Post> posts = postService.selectPostList();
        System.out.println("posts = \n" + JSON.toJSONString(posts) );
        return AjaxResult.success(posts);
    }

    @GetMapping("/hot")
    public AjaxResult hot(){
        List<Post> posts = postService.selectPostList();
        Collections.reverse(posts);
        return AjaxResult.success(posts);

    }


    @GetMapping("/follow")
    public AjaxResult follow(){
        List<Post> posts = postService.selectPostList();

        return AjaxResult.success(posts);
    }


    @PostMapping("/like/{postId}")
    public AjaxResult like(@PathVariable Long postId){

        long like = postService.likePost(postId);
        return AjaxResult.success(like);

    }














}
