package com.shop.active.serivce.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.shop.active.serivce.ActiveService;
import com.shop.order.service.OrderService;
import com.shop.common.entity.active.ActiveInfo;

/**
 * @author
 * @version $Id: ActiveServiceImpl.java,v 0.1 2021/7/2 15:36  Exp $
 */
@Service
public class ActiveServiceImpl implements ActiveService {

    @Reference
    private OrderService orderService;

    @Override
    public ActiveInfo getActiveInfo() {
        return new ActiveInfo("活动", Lists.newArrayList(orderService.getOrderInfo()));
    }
}
