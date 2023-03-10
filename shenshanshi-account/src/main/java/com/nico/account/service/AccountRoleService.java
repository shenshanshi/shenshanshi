package com.nico.account.service;

import com.nico.account.domain.AccountRole;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-10
 */
public interface AccountRoleService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param accountId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<AccountRole> selectAccountRoleByAccountId(Long accountId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param accountRole 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AccountRole> selectAccountRoleList(AccountRole accountRole);

    /**
     * 新增【请填写功能名称】
     *
     * @param accountRole 【请填写功能名称】
     * @return 结果
     */
    public int insertAccountRole(AccountRole accountRole);

    /**
     * 修改【请填写功能名称】
     *
     * @param accountRole 【请填写功能名称】
     * @return 结果
     */
    public int updateAccountRole(AccountRole accountRole);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param accountRole 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAccountRole(AccountRole accountRole);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param accountId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAccountRoleByAccountId(Long accountId);
}
