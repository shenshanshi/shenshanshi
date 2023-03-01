package com.nico.common.aspect;


import com.nico.common.annotation.Logical;
import com.nico.common.annotation.RequiresLogin;
import com.nico.common.annotation.RequiresPermissions;
import com.nico.common.annotation.RequiresRoles;
import com.nico.common.constant.RedisConstants;
import com.nico.common.exception.NotLoginException;
import com.nico.common.exception.NotPermissionException;
import com.nico.common.exception.NotRoleException;
import com.nico.common.utils.JwtUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 基于 Spring Aop 的注解鉴权
 */
@Aspect
@Component
public class PreAuthorizeAspect
{


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 构建
     */
    public PreAuthorizeAspect()
    {
    }

    /**
     * 定义AOP签名 (切入所有使用鉴权注解的方法)
     */
    public static final String POINTCUT_SIGN = " @annotation(com.nico.common.annotation.RequiresLogin) || "
            + "@annotation(com.nico.common.annotation.RequiresPermissions) || "
            + "@annotation(com.nico.common.annotation.RequiresRoles)";

    /**
     * 声明AOP签名
     */
    @Pointcut(POINTCUT_SIGN)
    public void pointcut()
    {
    }

    /**
     * 环绕切入
     *
     * @param joinPoint 切面对象
     * @return 底层方法执行后的返回值
     * @throws Throwable 底层方法抛出的异常
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable
    {
        // 注解鉴权
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        checkMethodAnnotation(signature.getMethod());
        try
        {
            // 执行原有逻辑
            Object obj = joinPoint.proceed();
            return obj;
        }
        catch (Throwable e)
        {
            throw e;
        }
    }

    /**
     * 对一个Method对象进行注解检查
     */
    public void checkMethodAnnotation(Method method)  {
        // 校验 @RequiresLogin 注解
        RequiresLogin requiresLogin = method.getAnnotation(RequiresLogin.class);
        if (requiresLogin != null)
        {
            //登录校验
            checkLogin();
        }

        // 校验 @RequiresRoles 注解
        RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
        if (requiresRoles != null)
        {
            //角色校验
            checkRole(requiresRoles);

        }

        // 校验 @RequiresPermissions 注解
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if (requiresPermissions != null)
        {
            //权限校验
            checkPermi(requiresPermissions);
        }
    }




    private void checkLogin() throws NotLoginException {

        String jwtToken = JwtUtils.getToken();
        if (jwtToken == null){
            throw new NotLoginException("token为空");
        }


        Long accountId = JwtUtils.getAccountId();
        String key = RedisConstants.TOKENPREFIX + accountId;

        Object result = redisTemplate.opsForValue().get(key);
        if (result == null || !jwtToken.equals(result.toString())){
            throw new NotLoginException("token无效");
        }


    }

    private void checkRole(RequiresRoles requiresRoles) {
        checkLogin();
        if (requiresRoles.logical() == Logical.AND){
            checkRoleAnd(requiresRoles.value());
        }else{
            checkRoleOr(requiresRoles.value());
        }

    }

    private void checkPermi(RequiresPermissions requiresPermissions) {
        checkLogin();
        List<String> permissions = JwtUtils.getPermissions();
        if (requiresPermissions.logical() == Logical.AND){
            checkPermiAnd(requiresPermissions.value());
        }else{
            checkPermiOr(requiresPermissions.value());
        }
    }




    private void checkRoleOr(String... roles) {
        List<String> roleList = JwtUtils.getRoles();


        for(String role : roles){

            if (roleList.contains(role)){
                return;
            }

        }
        if (roles.length > 0){
            throw new NotRoleException(roles);
        }


    }

    private void checkRoleAnd(String... roles) {
        List<String> roleList = JwtUtils.getRoles();
        for(String role : roles){

            if (!roleList.contains(role)){
                throw new NotRoleException(roles);
            }

        }
    }


    private void checkPermiOr(String... permissions) {
        List<String> permissionList = JwtUtils.getPermissions();
        for(String permission : permissions){

            if (permissionList.contains(permission)){
                return;
            }

        }
        if (permissions.length > 0){
            throw new NotPermissionException(permissions);
        }
    }

    private void checkPermiAnd(String... permissions) {
        List<String> permissionList = JwtUtils.getPermissions();
        for(String permission : permissions){

            if (!permissionList.contains(permission)){
                throw new NotPermissionException(permissions);
            }

        }
    }
}
