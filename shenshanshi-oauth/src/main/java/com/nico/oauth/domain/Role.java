package com.nico.oauth.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description role
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色标志
     */
    private String roleKey;

    /**
     * 状态
     */
    private Integer status;

    /**
     * del_flag
     */
    private Integer delFlag;

    /**
     * create_by
     */
    private String createBy;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * update_by
     */
    private String updateBy;

    /**
     * update_time
     */
    private Date updateTime;

    /**
     * remark
     */
    private String remark;

}