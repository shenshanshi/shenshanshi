package com.nico.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nico.oauth.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
