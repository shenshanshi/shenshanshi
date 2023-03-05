package com.nico.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.account.domain.Follow;
import com.nico.account.mapper.FollowMapper;
import com.nico.account.service.FollowService;
import com.nico.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public int insertFollow(Follow follow) {
        if (StringUtils.isNull(follow)){
            return 0;
        }

        int insert = followMapper.insert(follow);

        return insert;
    }

    @Override
    public int deleteFollow(Follow follow) {
        if (StringUtils.isNull(follow)){
            return 0;
        }
        QueryWrapper<Follow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("follw", follow.getFollw());
        queryWrapper.eq("be_follow", follow.getBeFollow());

        int delete = followMapper.delete(queryWrapper);
        return delete;
    }

    @Override
    public List<Follow> recommend(Long accountId) {
        List<Follow> follows = followMapper.selectList(null);

        return follows;
    }
}
