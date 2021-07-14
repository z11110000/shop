package com.shop.goods.service;

import com.alibaba.fastjson.JSONArray;
import com.shop.common.entity.base.Constant;
import com.shop.common.entity.order.OrderInfo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 * @version $Id: ConsumerLister.java,v 0.1 2021/7/5 15:03  Exp $
 */
@Component
public class ConsumerLister {

    @Autowired
    private GoodsService goodsService;

    @RabbitListener(queues = Constant.QUEUE_NAME)
    public void message(String str) {

        OrderInfo orderInfo = JSONArray.parseObject(str, OrderInfo.class);
        goodsService.subGoodsCount(orderInfo.getGoodsInfo());

    }


}
