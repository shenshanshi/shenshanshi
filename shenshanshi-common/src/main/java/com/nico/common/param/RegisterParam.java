package com.nico.common.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterParam {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 2, max = 10, message = "用户名长度为2-10个字符")
    private String accountName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "密码长度为6-16个字符")
    private String password;

}
