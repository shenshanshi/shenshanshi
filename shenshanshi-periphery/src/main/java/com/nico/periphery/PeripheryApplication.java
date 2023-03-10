package com.nico.periphery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nico")
@MapperScan("com.nico.periphery.mapper")
public class PeripheryApplication {
     public static void main(String[] args) {
         SpringApplication.run(PeripheryApplication.class, args);
          System.out.println("\n------------周边服务启动成功------------\n");

      }

}
