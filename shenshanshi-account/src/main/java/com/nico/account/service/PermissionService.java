package com.nico.account.service;

import com.nico.account.domain.Permission;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-10
 */
public interface PermissionService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param permId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Permission selectPermissionByPermId(Long permId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param permission 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Permission> selectPermissionList(Permission permission);

    /**
     * 新增【请填写功能名称】
     *
     * @param permission 【请填写功能名称】
     * @return 结果
     */
    public int insertPermission(Permission permission);

    /**
     * 修改【请填写功能名称】
     *
     * @param permission 【请填写功能名称】
     * @return 结果
     */
    public int updatePermission(Permission permission);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param permIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePermissionByPermIds(Long[] permIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param permId 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePermissionByPermId(Long permId);
}
