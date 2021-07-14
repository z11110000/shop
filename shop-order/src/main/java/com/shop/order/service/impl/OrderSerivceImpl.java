package com.shop.order.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import com.shop.goods.service.GoodsService;
import com.shop.middleware.mq.ProductService;
import com.shop.order.mapper.OrderMapper;
import com.shop.order.service.OrderService;
import com.shop.common.entity.goods.GoodsInfo;
import com.shop.common.entity.order.OrderInfo;
import com.shop.common.entity.utils.CovertorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author
 * @version $Id: OrderSerivceImpl.java,v 0.1 2021/7/2 15:12  Exp $
 */
@Service
public class OrderSerivceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSerivceImpl.class);

    @Reference
    private GoodsService goodsService;

    @Autowired
    private OrderMapper orderMapper;

    @Reference
    private ProductService productService;

    @Override
    public OrderInfo getOrderInfo() {

        GoodsInfo goodsInfo = goodsService.getGoodsInfo("11");
        goodsInfo.setCount(100);
        return new OrderInfo("111", "订单", goodsInfo);
    }

    @Transactional
    @Override
    public OrderInfo createOrder(OrderInfo orderInfo) {

        LOGGER.info("createOrder" + orderInfo);
        try {
            orderInfo.setOid(UUID.randomUUID().toString().replace("-", ""));

            orderMapper.createOrder(CovertorUtils.covertorOrderInfoToDo(orderInfo));

            productService.basicPublish(JSONArray.toJSONString(orderInfo));
            LOGGER.info("创建订单成功, orderInfo: {}", orderInfo);
            //throw new RuntimeException();

        }catch (Exception e){
            LOGGER.error("订单创建失败", e);
            throw new RuntimeException("订单创建失败");
        }

        return orderInfo;
    }
}
