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
    public int insert(Account account);

    /**
     * 删除
     */
    public int delete(Long id);

    /**
     * 更新
     */
    public int update(Account account);

    /**
     * 根据主键 id 查询
     */
    public Account get(Long id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

}