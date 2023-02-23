package com.nico.account;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountApplication {

     public static void main(String[] args) {
         SpringApplication.run(AccountApplication.class, args);
         System.out.println("\n------------账户服务启动成功------------\n");

     }

}
