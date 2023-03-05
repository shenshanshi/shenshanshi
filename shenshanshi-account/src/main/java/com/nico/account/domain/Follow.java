package com.nico.account.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description follow
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    /**
     * 关注者
     */
    @NotNull
    private Long follw;

    /**
     * 被关注者
     */
    @NotNull
    private Long beFollow;

}