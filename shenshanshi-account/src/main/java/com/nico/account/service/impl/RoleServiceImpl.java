package com.nico.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.account.domain.Role;
import com.nico.account.mapper.RoleMapper;
import com.nico.account.service.RoleService;
import com.nico.common.utils.DateUtils;
import com.nico.common.utils.QueryWrapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-10
 */
@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleMapper roleMapper;
    private static QueryWrapperUtils<Role> queryWrapperUtils = new QueryWrapperUtils();


    /**
     * 查询【请填写功能名称】
     *
     * @param roleId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Role selectRoleByRoleId(Long roleId)
    {
        return roleMapper.selectById(roleId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param role 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Role> selectRoleList(Role role)
    {
        QueryWrapper<Role> queryWrapper = queryWrapperUtils.getByNotNullField(role, Role.class);
        return roleMapper.selectList(queryWrapper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param role 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRole(Role role)
    {
        role.setCreateTime(DateUtils.getNowDate());
        return roleMapper.insert(role);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param role 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRole(Role role)
    {
        role.setUpdateTime(DateUtils.getNowDate());
        return roleMapper.updateById(role);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param roleIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRoleByRoleIds(Long[] roleIds)
    {
        return roleMapper.deleteBatchIds(Arrays.asList(roleIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param roleId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteRoleByRoleId(Long roleId)
    {
        return roleMapper.deleteById(roleId);
    }
}
