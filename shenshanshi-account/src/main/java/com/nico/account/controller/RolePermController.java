package com.nico.account.controller;

import com.nico.account.domain.RolePerm;
import com.nico.account.service.RolePermService;
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
@RequestMapping("/account/roleperm")
public class RolePermController extends BaseController
{
    @Autowired
    private RolePermService rolePermService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RolePerm rolePerm)
    {
        startPage();
        List<RolePerm> list = rolePermService.selectRolePermList(rolePerm);
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{roleId}")
    public TableDataInfo getInfo(@PathVariable("roleId") Long roleId)
    {        startPage();

        List<RolePerm> data = rolePermService.selectRolePermByRoleId(roleId);
        return getDataTable(data);
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody RolePerm rolePerm)
    {
        return toAjax(rolePermService.insertRolePerm(rolePerm));
    }

//    /**
//     * 修改【请填写功能名称】
//     */
//    @PutMapping
//    public AjaxResult edit(@RequestBody RolePerm rolePerm)
//    {
//        return toAjax(rolePermService.updateRolePerm(rolePerm));
//    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping
    public AjaxResult remove(@RequestBody RolePerm rolePerm)
    {
        return toAjax(rolePermService.deleteRolePerm(rolePerm));
    }
}
