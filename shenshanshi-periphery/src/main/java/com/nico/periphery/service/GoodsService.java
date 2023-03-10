package com.nico.periphery.service;

import com.nico.periphery.domain.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 查询【请填写功能名称】
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Goods selectGoodsByGoodsId(Long goodsId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param goodsIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteGoodsByGoodsIds(Long[] goodsIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGoodsByGoodsId(Long goodsId);

}
