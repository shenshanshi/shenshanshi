package com.nico.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nico.account.domain.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description accountMapper
 * @author nico
 * @date 2023-02-26
 */

@Mapper
public interface AccountMapper extends BaseMapper<Account> {


}