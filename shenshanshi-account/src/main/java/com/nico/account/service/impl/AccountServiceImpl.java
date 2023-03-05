package com.nico.account.service.impl;

import com.nico.account.domain.Account;
import com.nico.account.mapper.AccountMapper;
import com.nico.account.service.AccountService;
import com.nico.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;


    @Override
    public int insertAccount(Account account) {
        if (StringUtils.isNull(account)){
            return 0;
        }
        int insert = accountMapper.insert(account);
        return insert;
    }

    @Override
    public int deleteAccount(long accountId) {
        int delete = accountMapper.deleteById(accountId);
        return delete;
    }

    @Override
    public int updatAccount(Account account) {
        int update = accountMapper.updateById(account);
        return update;
    }

    @Override
    public Account selectAccountByAccountId(long accountId) {
        Account account = accountMapper.selectById(accountId);
        return account;
    }

    @Override
    public Map<String, Object> pageList(int offset, int pagesize) {
        return null;
    }
}