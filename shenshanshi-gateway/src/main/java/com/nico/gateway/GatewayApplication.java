package com.nico.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
     public static void main(String[] args) {
         SpringApplication.run(GatewayApplication.class, args);
         System.out.println("\n------------网关服务启动成功------------\n");
     }

}
