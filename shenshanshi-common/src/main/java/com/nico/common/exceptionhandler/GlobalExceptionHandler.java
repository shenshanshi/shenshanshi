package com.nico.common.exceptionhandler;


import com.nico.common.constant.HttpStatus;
import com.nico.common.exception.NotLoginException;
import com.nico.common.exception.NotPermissionException;
import com.nico.common.exception.NotRoleException;
import com.nico.common.web.domain.AjaxResult;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler
{

    /**
     * 登录验证异常
     */
    @ExceptionHandler(NotLoginException.class)
    public AjaxResult handleNotLoginException(NotLoginException e, HttpServletRequest request)
    {

        return AjaxResult.error(HttpStatus.FORBIDDEN, "未登录，" + e.getMessage());
    }

    /**
     * 权限验证异常
     */
    @ExceptionHandler(NotPermissionException.class)
    public AjaxResult handleNotPermissionException(NotPermissionException e, HttpServletRequest request)
    {
        return AjaxResult.error(HttpStatus.FORBIDDEN, "无权限：" + e.getMessage());
    }

    /**
     * 角色验证异常
     */
    @ExceptionHandler(NotRoleException.class)
    public AjaxResult handleNotRoleException(NotRoleException e, HttpServletRequest request)
    {
        return AjaxResult.error(HttpStatus.FORBIDDEN, "无角色：" + e.getMessage());
    }



    /**
     * 数据校验异常
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult handleBindException(BindException e)
    {
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return AjaxResult.error(message);
    }


    /**
     * 数据校验异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult exception(Exception e)
    {

        return AjaxResult.error("------------------");
    }






}
