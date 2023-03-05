package com.nico.forum.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description post
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 帖子id
     */
    private Long postId;

    /**
     * 帖子内容
     */
    private String postContent;

    /**
     * 点赞数
     */
    @TableField("`like`")
    private Long like;

    /**
     * 收藏
     */
    private Long collect;

    /**
     * 作者
     */
    private Long accountId;

    /**
     * 发表时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}