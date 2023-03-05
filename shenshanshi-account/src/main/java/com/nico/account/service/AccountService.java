package com.nico.account.service;

import com.nico.account.domain.Account;

import java.util.Map;
/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
public interface AccountService {

    /**
     * 新增
     */
    public int insertAccount(Account account);

    /**
     * 删除
     */
    public int deleteAccount(long accountId);

    /**
     * 更新
     */
    public int updatAccount(Account account);

    /**
     * 根据主键 id 查询
     */
    public Account selectAccountByAccountId(long accountId);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}