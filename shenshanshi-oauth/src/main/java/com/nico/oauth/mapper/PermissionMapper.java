package com.nico.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nico.oauth.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT * FROM permission WHERE perm_id IN( SELECT perm_id FROM role_perm WHERE role_id IN( SELECT role_id FROM account_role WHERE account_id = #{accountId}))")
    public List<Permission> selectPermissionByAccountId(Long accountId);


    @Select("SELECT * FROM permission WHERE perm_id IN( SELECT perm_id FROM role_perm WHERE role_id = #{roleId})")
    public List<Permission> selectPermissionByRoleId(Long roleId);
}
