package com.nico.account.service.impl;

import com.nico.account.domain.Account;
import com.nico.account.mapper.AccountMapper;
import com.nico.account.service.AccountService;
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
    public int insert(Account account) {

        if (account == null) return 0;

        return accountMapper.insert(account);

    }

    @Override
    public int delete(Long id) {
        return 0;
    }


    @Override
    public int update(Account account) {
        return 0;
    }


    @Override
    public Account get(Long id) {
        return accountMapper.selectById(id);
    }



    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

//        Page<Account> page = new Page<>(offset, pagesize);
//
//        accountMapper.selectMapsPage(page, null);

        return null;

    }

}