package com.nico.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.account.domain.Permission;
import com.nico.account.mapper.PermissionMapper;
import com.nico.account.service.PermissionService;
import com.nico.common.utils.DateUtils;
import com.nico.common.utils.QueryWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-10
 */
@Service
public class PermissionServiceImpl implements PermissionService
{
    @Autowired
    private PermissionMapper permissionMapper;
    private static QueryWrapperUtils<Permission> queryWrapperUtils = new QueryWrapperUtils();

    /**
     * 查询【请填写功能名称】
     *
     * @param permId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Permission selectPermissionByPermId(Long permId)
    {
        return permissionMapper.selectById(permId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param permission 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Permission> selectPermissionList(Permission permission)
    {
        QueryWrapper<Permission> queryWrapper = queryWrapperUtils.getByNotNullField(permission, Permission.class);
        return permissionMapper.selectList(queryWrapper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param permission 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPermission(Permission permission)
    {
        permission.setCreateTime(DateUtils.getNowDate());
        return permissionMapper.insert(permission);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param permission 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePermission(Permission permission)
    {
        permission.setUpdateTime(DateUtils.getNowDate());
        return permissionMapper.updateById(permission);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param permIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePermissionByPermIds(Long[] permIds)
    {
        return permissionMapper.deleteBatchIds(Arrays.asList(permIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param permId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePermissionByPermId(Long permId)
    {
        return permissionMapper.deleteById(permId);
    }
}
