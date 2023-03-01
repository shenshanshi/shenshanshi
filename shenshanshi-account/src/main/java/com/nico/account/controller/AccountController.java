package com.nico.account.controller;


import com.nico.account.domain.Account;
import com.nico.account.service.AccountService;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description account
 * @author nico
 * @date 2023-02-26
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 新增
     * @author nico
     * @date 2023/02/26
     **/
    @RequestMapping("/insert")
    public AjaxResult insert(@RequestBody Account account){

        if (account == null)
            return AjaxResult.error();

        int insert = accountService.insert(account);
        if (insert > 0)
            return AjaxResult.success();
        return AjaxResult.error();

    }

    /**
     * 刪除
     * @author nico
     * @date 2023/02/26
     **/
    @RequestMapping("/delete")
    public AjaxResult delete(Long id){
        int delete = accountService.delete(id);
        return AjaxResult.success(delete);
    }

    /**
     * 更新
     * @author nico
     * @date 2023/02/26
     **/
    @RequestMapping("/update")
    public AjaxResult update(Account account){
        accountService.update(account);

        return AjaxResult.success();
    }

    /**
     * 查询 根据主键 id 查询
     * @author nico
     * @date 2023/02/26
     **/
    @RequestMapping("/account/{accountId}")
    public Account load(@PathVariable Long accountId){
        return accountService.get(accountId);
    }

    /**
     * 查询 分页查询
     * @author nico
     * @date 2023/02/26
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return accountService.pageList(offset, pagesize);
    }

}