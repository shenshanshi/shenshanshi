package com.nico.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nico")
@MapperScan("com.nico.oauth.mapper")
public class OauthApplication {
     public static void main(String[] args) {
         SpringApplication.run(OauthApplication.class, args);
         System.out.println("\n------------认证服务服务启动成功------------\n");
     }

}
