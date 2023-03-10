package com.nico.account.service.impl;

import com.nico.account.domain.Account;
import com.nico.account.mapper.AccountMapper;
import com.nico.account.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param accountId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Account selectAccountByAccountId(Long accountId)
    {
        return accountMapper.selectById(accountId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @return 【请填写功能名称】
     */
    @Override
    public List<Account> selectAccountList()
    {
        return accountMapper.selectList(null);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param account 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAccount(Account account)
    {
        return accountMapper.insert(account);

    }

    /**
     * 修改【请填写功能名称】
     *
     * @param account 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAccount(Account account)
    {

        return accountMapper.updateById(account);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param accountIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAccountByAccountIds(Long[] accountIds)
    {
        return accountMapper.deleteBatchIds(Arrays.asList(accountIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param accountId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAccountByAccountId(Long accountId)
    {
        return accountMapper.deleteById(accountId);
    }
}
