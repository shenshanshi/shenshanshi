package com.nico.account.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 【请填写功能名称】对象 role_perm
 *
 * @author nico
 * @date 2023-03-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePerm implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 角色id */
    private Long roleId;

    /** 权限id */
    private Long permId;


}
