package com.nico.periphery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.common.utils.QueryWrapperUtils;
import com.nico.periphery.domain.Goods;
import com.nico.periphery.mapper.GoodsMapper;
import com.nico.periphery.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    QueryWrapperUtils<Goods> queryWrapperUtils = new QueryWrapperUtils<>();

    /**
     * 查询【请填写功能名称】
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Goods selectGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.selectById(goodsId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        QueryWrapper<Goods> queryWrapper = queryWrapperUtils.getByNotNullField(goods, Goods.class);
        return goodsMapper.selectList(queryWrapper);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGoods(Goods goods)
    {
        return goodsMapper.insert(goods);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGoods(Goods goods)
    {
        return goodsMapper.updateById(goods);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param goodsIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsIds(Long[] goodsIds)
    {
        return goodsMapper.deleteBatchIds(Arrays.asList(goodsIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param goodsId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsId(Long goodsId)
    {
        return goodsMapper.deleteById(goodsId);
    }
}
