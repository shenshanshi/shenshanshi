package com.nico.periphery.controller;

import com.nico.common.web.controller.BaseController;
import com.nico.common.web.domain.AjaxResult;
import com.nico.common.web.page.TableDataInfo;
import com.nico.periphery.domain.Goods;
import com.nico.periphery.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periphery/goods")
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;


    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */

    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return success(goodsService.selectGoodsByGoodsId(goodsId));
    }

    /**
     * 新增【请填写功能名称】
     */

    @PostMapping
    public AjaxResult add(@RequestBody Goods goods)
    {
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改【请填写功能名称】
     */

    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods)
    {
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除【请填写功能名称】
     */

    @DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(goodsService.deleteGoodsByGoodsIds(goodsIds));
    }


}
