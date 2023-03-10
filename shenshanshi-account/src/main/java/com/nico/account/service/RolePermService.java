package com.nico.account.service;

import com.nico.account.domain.RolePerm;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-10
 */
public interface RolePermService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param roleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<RolePerm> selectRolePermByRoleId(Long roleId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param rolePerm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<RolePerm> selectRolePermList(RolePerm rolePerm);

    /**
     * 新增【请填写功能名称】
     *
     * @param rolePerm 【请填写功能名称】
     * @return 结果
     */
    public int insertRolePerm(RolePerm rolePerm);

    /**
     * 修改【请填写功能名称】
     *
     * @param rolePerm 【请填写功能名称】
     * @return 结果
     */
    public int updateRolePerm(RolePerm rolePerm);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param roleIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteRolePermByRoleIds(Long[] roleIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param roleId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteRolePermByRoleId(Long roleId);

    public int deleteRolePerm(RolePerm rolePerm);

}
