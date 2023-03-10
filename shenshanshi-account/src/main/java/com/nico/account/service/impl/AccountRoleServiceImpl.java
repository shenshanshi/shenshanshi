package com.nico.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.account.domain.AccountRole;
import com.nico.account.mapper.AccountRoleMapper;
import com.nico.account.service.AccountRoleService;
import com.nico.common.utils.QueryWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-10
 */
@Service
public class AccountRoleServiceImpl implements AccountRoleService
{
    @Autowired
    private AccountRoleMapper accountRoleMapper;
    private static QueryWrapperUtils<AccountRole> queryWrapperUtils = new QueryWrapperUtils();

    /**
     * 查询【请填写功能名称】
     *
     * @param accountId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public List<AccountRole> selectAccountRoleByAccountId(Long accountId)
    {
        QueryWrapper<AccountRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", accountId);
        return accountRoleMapper.selectList(queryWrapper);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param accountRole 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AccountRole> selectAccountRoleList(AccountRole accountRole)
    {
        QueryWrapper<AccountRole> queryWrapper = queryWrapperUtils.getByNotNullField(accountRole, AccountRole.class);
        return accountRoleMapper.selectList(queryWrapper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param accountRole 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAccountRole(AccountRole accountRole)
    {
        return accountRoleMapper.insert(accountRole);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param accountRole 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAccountRole(AccountRole accountRole)
    {
        return accountRoleMapper.updateById(accountRole);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param accountRole, roleId 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAccountRole(AccountRole accountRole)
    {
        QueryWrapper<AccountRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", accountRole.getAccountId());
        queryWrapper.eq("role_id", accountRole.getRoleId());
        return accountRoleMapper.delete(queryWrapper);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param accountId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAccountRoleByAccountId(Long accountId)
    {
        return accountRoleMapper.deleteById(accountId);
    }
}
