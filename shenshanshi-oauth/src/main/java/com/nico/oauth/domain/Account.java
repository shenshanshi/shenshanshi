package com.nico.oauth.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 用户id
     */
    private Long accountId;

    /**
     * 用户名
     */
    private String accountName;

    /**
     * 用户昵称
     */
    private String nikeName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * qq号
     */
    private Long qq;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 个性签名
     */
    private String personalSignature;

    /**
     * 最后登录ip
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 删除标志
     */
    private Integer delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;
}