package com.nico.resource.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description resource
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-09
 */
@Data
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 资源id
     */
    private Long resourceId;

    /**
     * 资源名
     */
    private String name;

    /**
     * 下载路径
     */
    private String path;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 资源简介
     */
    private String briefIntroduction;

    /**
     * 下载量
     */
    private Long download;

    /**
     * 图片地址
     */
    private String picture;

    /**
     * 资源标签
     */
    private String label;

}
