package com.nico.periphery.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description goods
 * @author zhengkai.blog.csdn.net
 * @date 2023-03-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 单价
     */
    private Double price;

    /**
     * 图片
     */
    private String picture;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 类型
     */
    private String type;

    /**
     * 销量
     */
    private Long sales;

}
