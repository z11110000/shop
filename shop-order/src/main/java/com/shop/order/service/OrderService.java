package com.shop.order.service;

import com.shop.common.entity.order.OrderInfo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: OrderService.java,v 0.1 2021/7/2 15:09  Exp $
 */
public interface OrderService {

    OrderInfo getOrderInfo();

    OrderInfo createOrder(OrderInfo orderInfo) throws IOException, TimeoutException;
}
