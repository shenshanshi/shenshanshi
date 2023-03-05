package com.nico.account.service;

import com.nico.account.domain.Follow;

import java.util.List;

public interface FollowService {
    int insertFollow(Follow follow);
    int deleteFollow(Follow follow);
    List<Follow> recommend(Long accountId);
}
