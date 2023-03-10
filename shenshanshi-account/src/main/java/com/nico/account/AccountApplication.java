package com.nico.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.nico")
@EnableDiscoveryClient
@MapperScan("com.nico.account.mapper")
@EnableSwagger2

public class AccountApplication {

     public static void main(String[] args) {
         SpringApplication.run(AccountApplication.class, args);
         System.out.println("\n------------账户服务启动成功------------\n");

     }

}
