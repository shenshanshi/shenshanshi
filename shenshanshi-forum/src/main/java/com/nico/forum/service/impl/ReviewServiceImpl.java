package com.nico.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.common.utils.BeanUtils;
import com.nico.common.utils.StringUtils;
import com.nico.forum.domain.Review;
import com.nico.forum.domain.vo.ReviewVo;
import com.nico.forum.mapper.ReviewMapper;
import com.nico.forum.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<ReviewVo> selectReviewByPostId(Long postId) {

        if (StringUtils.isNull(postId)){
            return null;
        }

        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", postId);
        List<Review> reviews = reviewMapper.selectList(queryWrapper);




        List<ReviewVo> ReviewVos = new ArrayList<>();

        for(Review review : reviews){

            ReviewVo reviewVo = new ReviewVo();
            BeanUtils.copyBeanProp(reviewVo, review);


            QueryWrapper<Review> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("parent_id", reviewVo.getReviewId());
            List<Review> reviews1 = reviewMapper.selectList(queryWrapper1);

            reviewVo.setChild(reviews1);

            ReviewVos.add(reviewVo);

        }


        return ReviewVos;
    }

    @Override
    public Long selectViewCountByPostId(Long postId) {
        long count = 0;
        if (StringUtils.isNull(postId)){
            return count;
        }

        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", postId);
        List<Review> reviews = reviewMapper.selectList(queryWrapper);

        if (StringUtils.isNull(reviews)){
            return count;
        }

        count = reviews.size();
        System.out.println("count = " + count);


        for(Review review : reviews){



            QueryWrapper<Review> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("parent_id", review.getReviewId());
            Long aLong = reviewMapper.selectCount(queryWrapper1);
            count += aLong;



        }


        return count;
    }

    @Override
    public long updateReviewLikeById(long reviewId, long number) {

        Review review = reviewMapper.selectById(reviewId);
        if (StringUtils.isNull(review)){
            return 0L;
        }

        long count = number + review.getLike();
        review.setLike(count);
        reviewMapper.updateById(review);
        return count;



    }

    @Override
    public long updateReviewNotLikeById(long reviewId, long number) {
        Review review = reviewMapper.selectById(reviewId);
        if (StringUtils.isNull(review)){
            return 0L;
        }

        long count = number + review.getNotlike();
        review.setNotlike(count);
        reviewMapper.updateById(review);

        return count;
    }


}
