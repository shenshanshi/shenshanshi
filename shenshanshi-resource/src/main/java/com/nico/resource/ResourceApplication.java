package com.nico.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nico")
@MapperScan("com.nico.resource.mapper")
public class ResourceApplication {
     public static void main(String[] args) {
         SpringApplication.run(ResourceApplication.class, args);
          System.out.println("\n------------资源服务启动成功------------\n");

      }

}
