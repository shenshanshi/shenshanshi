package com.nico.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.account.domain.RolePerm;
import com.nico.account.mapper.RolePermMapper;
import com.nico.account.service.RolePermService;
import com.nico.common.utils.QueryWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author nico
 * @date 2023-03-10
 */
@Service
public class RolePermServiceImpl implements RolePermService
{
    @Autowired
    private RolePermMapper rolePermMapper;
    private static QueryWrapperUtils<RolePerm> queryWrapperUtils = new QueryWrapperUtils();

    /**
     * 查询【请填写功能名称】
     *
     * @param roleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public List<RolePerm> selectRolePermByRoleId(Long roleId)
    {
        QueryWrapper<RolePerm> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        return rolePermMapper.selectList(queryWrapper);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param rolePerm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<RolePerm> selectRolePermList(RolePerm rolePerm)
    {
        QueryWrapper<RolePerm> queryWrapper = queryWrapperUtils.getByNotNullField(rolePerm, RolePerm.class);
        return rolePermMapper.selectList(queryWrapper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param rolePerm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRolePerm(RolePerm rolePerm)
    {
        return rolePermMapper.insert(rolePerm);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param rolePerm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRolePerm(RolePerm rolePerm)
    {
        return rolePermMapper.updateById(rolePerm);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param roleIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRolePermByRoleIds(Long[] roleIds)
    {
        return rolePermMapper.deleteBatchIds(Arrays.asList(roleIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param roleId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRolePermByRoleId(Long roleId)
    {
        return rolePermMapper.deleteById(roleId);
    }

    @Override
    public int deleteRolePerm(RolePerm rolePerm) {
        QueryWrapper<RolePerm> queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", rolePerm.getRoleId());
        queryWrapper.eq("perm_id", rolePerm.getPermId());
        int delete = rolePermMapper.delete(queryWrapper);
        return delete;
    }
}
