package com.nico.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.nico")
@MapperScan("com.nico.forum.mapper")
@EnableDiscoveryClient
public class ForumApplication {
     public static void main(String[] args) {
         SpringApplication.run(ForumApplication.class, args);
          System.out.println("\n------------论坛服务启动成功------------\n");
          
      }
     
}
