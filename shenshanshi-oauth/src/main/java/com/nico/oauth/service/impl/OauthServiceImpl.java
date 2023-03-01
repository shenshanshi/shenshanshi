package com.nico.oauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nico.common.utils.StringUtils;
import com.nico.oauth.domain.Account;
import com.nico.oauth.domain.Permission;
import com.nico.oauth.domain.Role;
import com.nico.oauth.mapper.AccountMapper;
import com.nico.oauth.mapper.PermissionMapper;
import com.nico.oauth.mapper.RoleMapper;
import com.nico.oauth.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OauthServiceImpl implements OauthService {



    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;


    /**
     *
     *通过账号名查找账号信息
     * @param accountName
     * @return
     */

    @Override
    public Account selectAccountByAccountName(String accountName) {
        //1、定义查询条件
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_name", accountName);

        //2、查询数据库
        Account account = accountMapper.selectOne(queryWrapper);

        //3、返回结果
        return account;

    }

    @Override
    public List<String> selectRoleByAccountId(Long accountId) {

        if (StringUtils.isNull(accountId)){
            return null;
        }

        List<Role> roles = roleMapper.selectRoleByAccountId(accountId);
        List<String> roleString = roles.stream().map(item -> item.getRoleKey()).collect(Collectors.toList());
        return roleString;
    }

    @Override
    public List<String> selectPermissionByAccountId(Long accountId) {

        if (StringUtils.isNull(accountId)){
            return null;
        }

        List<Permission> permissions = permissionMapper.selectPermissionByAccountId(accountId);
        List<String> permissionString = permissions.stream().map(item -> item.getPermKey()).collect(Collectors.toList());
        return permissionString;
    }

    @Override
    public int insertAccount(Account account) {

        if (StringUtils.isNull(account)){
            return 0;
        }

        int insert = accountMapper.insert(account);
        return insert;
    }
}
