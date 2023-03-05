package com.nico.forum.service.impl;

import com.nico.forum.domain.Post;
import com.nico.forum.mapper.PostMapper;
import com.nico.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public Post selectPostById(Long postId) {
        Post post = postMapper.selectById(postId);
        postMapper.selectList(null);
        return post;
    }

    @Override
    public List<Post> selectPostList() {
        List<Post> posts = postMapper.selectList(null);
        return posts;
    }

    @Override
    public long likePost(Long postId) {
        Post post = postMapper.selectById(postId);
        post.setLike(post.getLike() + 1);
        postMapper.updateById(post);
        return post.getLike();
    }


}
