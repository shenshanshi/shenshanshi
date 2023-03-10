package com.nico.account.controller;

import com.nico.account.domain.AccountRole;
import com.nico.account.service.AccountRoleService;
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
@RequestMapping("/account/accountrole")
public class AccountRoleController extends BaseController
{
    @Autowired
    private AccountRoleService accountRoleService;

    /**
     * 查询【请填写功能名称】列表
     */

    @GetMapping("/list")
    public TableDataInfo list(AccountRole accountRole)
    {
        startPage();
        List<AccountRole> list = accountRoleService.selectAccountRoleList(accountRole);
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/list/{accountId}")
    public TableDataInfo getInfo(@PathVariable("accountId") Long accountId)
    {
        startPage();
        List<AccountRole> list = accountRoleService.selectAccountRoleByAccountId(accountId);
        return getDataTable(list);
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody AccountRole accountRole)
    {
        return toAjax(accountRoleService.insertAccountRole(accountRole));
    }

//    /**
//     * 修改【请填写功能名称】
//     */
//    @PutMapping
//    public AjaxResult edit(@RequestBody AccountRole accountRole)
//    {
//        return toAjax(accountRoleService.updateAccountRole(accountRole));
//    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping
    public AjaxResult remove(@RequestBody AccountRole accountRole)
    {
        return toAjax(accountRoleService.deleteAccountRole(accountRole));
    }
}
