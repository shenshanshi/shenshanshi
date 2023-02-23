package com.nico.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long accountId;

    private String accountName;

    private String nickName;

    private String psaaword;

    private String salt;

    private String avatar;

    private String email;

    private String qq;

    private Integer sex;

    private String personal_signature;

    private String loginIp;

    private Date loginDate;

    private Integer status;

    private Integer delFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String remark;

}
