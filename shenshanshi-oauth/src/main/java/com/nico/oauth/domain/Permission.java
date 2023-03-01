package com.nico.oauth.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description permission
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 权限id
     */
    private Long permId;

    /**
     * 权限名
     */
    private String permName;

    /**
     * 权限标识
     */
    private String permKey;

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