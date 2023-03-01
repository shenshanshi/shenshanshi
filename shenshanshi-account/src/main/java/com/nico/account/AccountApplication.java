package com.nico.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.nico")
@EnableDiscoveryClient
@MapperScan("com.nico.account.mapper")
public class AccountApplication {

     public static void main(String[] args) {
         SpringApplication.run(AccountApplication.class, args);
         System.out.println("\n------------账户服务启动成功------------\n");

     }

}
