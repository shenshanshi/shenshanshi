package com.nico.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nico.oauth.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {


    @Select("SELECT * FROM role WHERE role_id IN (SELECT role_id FROM account_role WHERE account_id = #{accountId})")
    public List<Role> selectRoleByAccountId(Long accountId);

}
