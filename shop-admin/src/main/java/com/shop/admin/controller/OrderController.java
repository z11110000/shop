package com.shop.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.order.service.OrderService;
import com.shop.common.entity.order.OrderInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: OrderController.java,v 0.1 2021/7/2 15:17  Exp $
 */
@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @GetMapping("getOrderInfo")
    public OrderInfo getOrderInfo(){

        return orderService.getOrderInfo();
    }

    @GetMapping("createOrder")
    public OrderInfo createOrder() throws IOException, TimeoutException {

        return orderService.createOrder(orderService.getOrderInfo());
    }

}
