package com.nico.forum.controller;

import com.nico.common.web.domain.AjaxResult;
import com.nico.forum.domain.vo.ReviewVo;
import com.nico.forum.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;





    @GetMapping("/postId/{postId}")
    public AjaxResult getReviews(@PathVariable Long postId){

        List<ReviewVo> list = reviewService.selectReviewByPostId(postId);

        return AjaxResult.success(list);

    }
    @GetMapping("/reviewcountByPostId/{postId}")
    public AjaxResult viewcountByPostId(@PathVariable Long postId){

        Long aLong = reviewService.selectViewCountByPostId(postId);

        return AjaxResult.success(aLong);

    }

    @PostMapping("/like/{postId}")
    public AjaxResult like(@PathVariable Long postId, Long number){

        long count = reviewService.updateReviewLikeById(postId, number);
        return AjaxResult.success(count);

    }

    @PostMapping("/notlike/{postId}")
    public AjaxResult notlike(@PathVariable Long postId, Long number){

        long count = reviewService.updateReviewNotLikeById(postId, number);
        return AjaxResult.success(count);

    }


}
