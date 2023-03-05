package com.nico.common.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class JwtUtils {


    /**
     * 过期时间
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    /**
     * 令牌秘钥
     */
    private static final String SECRET = "niconiconi!";


    /**
     * 生成token
     * @param accountId
     * @return
     */
    public static String createToken (Long accountId, List<String> roles, List<String> permissions){

        String jwtToken = Jwts.builder()

                //设置头部信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                //设置主题
                .setSubject("sso")

                //设置Payload
                .claim("accountId", accountId)
                .claim("roles", roles)
                .claim("permissions", permissions)

                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))


                //设置加密
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();


        return jwtToken;

    }


    /**
     * 判断token是否存在与有效
     * @return
     */
    public static boolean checkToken() {
        String jwtToken = getToken();
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取用户名
     * @return
     */
    public static long getAccountId() {

        String jwtToken = getToken();

        Jws<Claims> claimsJws;
        try {
            claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
//            e.printStackTrace();
            return 0;
        }
        Claims claims = claimsJws.getBody();
        Long accountId = Long.valueOf(claims.get("accountId").toString());

        return accountId;
    }

    /**
     * 根据token获取角色
     * @return
     */
    public static List<String> getRoles() {

        String jwtToken = getToken();

        Jws<Claims> claimsJws;
        try {
            claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
//            e.printStackTrace();
            return null;
        }
        Claims claims = claimsJws.getBody();

        List<String> roles = (List<String>) claims.get("roles");

        return roles;
    }

    /**
     * 根据token获取权限
     * @return
     */
    public static  List<String>  getPermissions() {

        String jwtToken = getToken();

        Jws<Claims> claimsJws;
        try {
            claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
//            e.printStackTrace();
            return null;
        }
        Claims claims = claimsJws.getBody();
        List<String> permissions = (List<String>) claims.get("permissions");
        return permissions;
    }


    /**
     * 根据Bearer认证标准从用户请求中获取token
     * @return
     */
    public static String getToken()  {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String authorization  = request.getHeader("Authorization");

        if (StringUtils.isEmpty(authorization)){
            return null;
        }

        String jwtToken = authorization.replace("Bearer ", "");
//        System.out.println(jwtToken);

        return jwtToken;

    }





}

