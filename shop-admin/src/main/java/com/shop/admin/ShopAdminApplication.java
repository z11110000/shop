package com.shop.admin;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ShopAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopAdminApplication.class, args);
	}

}
