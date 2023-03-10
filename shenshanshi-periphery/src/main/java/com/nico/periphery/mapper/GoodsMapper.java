package com.nico.periphery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nico.periphery.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
