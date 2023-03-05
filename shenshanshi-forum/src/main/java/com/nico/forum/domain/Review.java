package com.nico.forum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description review
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 评论id
     */
    private Long reviewId;

    /**
     * 评论内容
     */
    private String reviewContent;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 评论者
     */
    private Long accountId;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 点赞
     */
    @TableField("`like`")
    private Long like;

    /**
     * 踩
     */
//    @TableField("`notlike`")
    private Long notlike;


}