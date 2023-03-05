package com.nico.forum.service;

import com.nico.forum.domain.vo.ReviewVo;

import java.util.List;

public interface ReviewService {

    List<ReviewVo> selectReviewByPostId(Long postId);
    Long selectViewCountByPostId(Long postId);

    long updateReviewLikeById(long reviewId, long number);
    long updateReviewNotLikeById(long reviewId, long number);

}
