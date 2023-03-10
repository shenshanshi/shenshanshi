package com.nico.account.controller;


import com.nico.account.domain.Permission;
import com.nico.account.service.PermissionService;
import com.nico.common.web.controller.BaseController;
import com.nico.common.web.domain.AjaxResult;
import com.nico.common.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-03-10
 */
@RestController
@RequestMapping("/account/permission")
public class PermissionController extends BaseController
{
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Permission permission)
    {
        startPage();
        List<Permission> list = permissionService.selectPermissionList(permission);
        return getDataTable(list);
    }



    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{permId}")
    public AjaxResult getInfo(@PathVariable("permId") Long permId)
    {
        return success(permissionService.selectPermissionByPermId(permId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody Permission permission)
    {
        return toAjax(permissionService.insertPermission(permission));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Permission permission)
    {
        return toAjax(permissionService.updatePermission(permission));
    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping("/{permIds}")
    public AjaxResult remove(@PathVariable Long[] permIds)
    {
        return toAjax(permissionService.deletePermissionByPermIds(permIds));
    }
}
