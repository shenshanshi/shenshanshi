package com.nico.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description account_role
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 角色id
     */
    private Long roleId;

}
