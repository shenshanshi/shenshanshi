package com.nico.oauth.service;

import com.nico.oauth.domain.Account;

import java.util.List;

public interface OauthService {
    /**
     * 通过账号名查找账号信息
     * @param accountName
     * @return
     */
    Account selectAccountByAccountName(String accountName);

    /**
     * 通过账号id查找账号角色
     * @param accountId
     * @return
     */
    List<String> selectRoleByAccountId(Long accountId);

    /**
     * 通过账号id查找账号权限
     * @param accountId
     * @return
     */
    List<String> selectPermissionByAccountId(Long accountId);

    /**
     * 将账户保存到数据库
     * @param account
     * @return
     */
    int insertAccount(Account account);



}
