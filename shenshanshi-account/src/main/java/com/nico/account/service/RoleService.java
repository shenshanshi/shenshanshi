package com.nico.account.service;

import com.nico.account.domain.Role;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-10
 */
public interface RoleService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param roleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Role selectRoleByRoleId(Long roleId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param role 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Role> selectRoleList(Role role);

    /**
     * 新增【请填写功能名称】
     *
     * @param role 【请填写功能名称】
     * @return 结果
     */
    public int insertRole(Role role);

    /**
     * 修改【请填写功能名称】
     *
     * @param role 【请填写功能名称】
     * @return 结果
     */
    public int updateRole(Role role);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param roleIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRoleByRoleIds(Long[] roleIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param roleId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRoleByRoleId(Long roleId);
}
