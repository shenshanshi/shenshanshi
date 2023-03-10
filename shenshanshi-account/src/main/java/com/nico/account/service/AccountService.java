package com.nico.account.service;

import com.nico.account.domain.Account;

import java.util.List;
/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
public interface AccountService {






    /**
     * 查询【请填写功能名称】
     *
     * @param accountId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Account selectAccountByAccountId(Long accountId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param
     * @return 【请填写功能名称】集合
     */
    public List<Account> selectAccountList();

    /**
     * 新增【请填写功能名称】
     *
     * @param account 【请填写功能名称】
     * @return 结果
     */
    public int insertAccount(Account account);

    /**
     * 修改【请填写功能名称】
     *
     * @param account 【请填写功能名称】
     * @return 结果
     */
    public int updateAccount(Account account);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param accountIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAccountByAccountIds(Long[] accountIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param accountId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAccountByAccountId(Long accountId);

}
