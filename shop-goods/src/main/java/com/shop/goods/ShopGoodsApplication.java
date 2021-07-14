package com.shop.goods;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.shop.goods.mapper")
@EnableTransactionManagement
@EnableDubbo
@SpringBootApplication
public class ShopGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopGoodsApplication.class, args);
	}

}
