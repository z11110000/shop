package com.shop.order.mapper;

import com.shop.common.entity.order.OrderDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @version $Id: OrderDao.java,v 0.1 2021/7/5 16:01  Exp $
 */
public interface OrderMapper {

    int createOrder(OrderDO orderDO);

    OrderDO select(@Param("oid")String oid);

}
