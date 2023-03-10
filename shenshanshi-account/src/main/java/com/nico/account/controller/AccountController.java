package com.nico.account.controller;


import com.nico.account.domain.Account;
import com.nico.account.service.AccountService;
import com.nico.common.annotation.RequiresLogin;
import com.nico.common.utils.JwtUtils;
import com.nico.common.web.controller.BaseController;
import com.nico.common.web.domain.AjaxResult;
import com.nico.common.web.page.TableDataInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/account/account")
public class AccountController extends BaseController {

    @Resource
    private AccountService accountService;




    /**
     * 查询 根据主键 id 查询
     * @author nico
     * @date 2023/02/26
     **/
    @GetMapping
    @RequiresLogin
    public AjaxResult getAccount(){
        long accountId = JwtUtils.getAccountId();

        Account account = accountService.selectAccountByAccountId(accountId);

        return AjaxResult.success(account);
    }




    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list()
    {
        startPage();
        List<Account> list = accountService.selectAccountList();
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{accountId}")
    public AjaxResult getInfo(@PathVariable("accountId") Long accountId)
    {
        return success(accountService.selectAccountByAccountId(accountId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody Account account)
    {
        return toAjax(accountService.insertAccount(account));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Account account)
    {
        return toAjax(accountService.updateAccount(account));
    }

    /**
     * 删除【请填写功能名称】
     */

    @DeleteMapping("/{accountIds}")
    public AjaxResult remove(@PathVariable Long[] accountIds)
    {
        return toAjax(accountService.deleteAccountByAccountIds(accountIds));
    }

}
