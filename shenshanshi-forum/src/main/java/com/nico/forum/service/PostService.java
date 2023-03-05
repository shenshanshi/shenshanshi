package com.nico.forum.service;

import com.nico.forum.domain.Post;

import java.util.List;

public interface PostService {

    Post selectPostById(Long postId);

    List<Post> selectPostList();

    long likePost(Long postId);

}
