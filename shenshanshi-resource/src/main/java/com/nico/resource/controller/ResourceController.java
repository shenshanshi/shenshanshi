package com.nico.resource.controller;

import com.nico.common.web.controller.BaseController;
import com.nico.common.web.domain.AjaxResult;
import com.nico.common.web.page.TableDataInfo;
import com.nico.resource.domain.Resource;
import com.nico.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 查询【请填写功能名称】列表
     */

    @GetMapping("/list")
    public TableDataInfo list(Resource resource)
    {
        startPage();
        List<Resource> list = resourceService.selectResourceList(resource);
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{resourceId}")
    public AjaxResult getInfo(@PathVariable("resourceId") Long resourceId)
    {
        return success(resourceService.selectResourceByResourceId(resourceId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody Resource resource)
    {
        return toAjax(resourceService.insertResource(resource));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Resource resource)
    {
        return toAjax(resourceService.updateResource(resource));
    }

    /**
     * 删除【请填写功能名称】
     */
    @DeleteMapping("/{resourceIds}")
    public AjaxResult remove(@PathVariable Long[] resourceIds)
    {
        return toAjax(resourceService.deleteResourceByResourceIds(resourceIds));
    }
}
