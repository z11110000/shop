package com.shop.middleware;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ShopMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMiddlewareApplication.class, args);
	}

}
