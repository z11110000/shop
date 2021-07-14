package com.shop.common.entity.utils;

import com.alibaba.fastjson.JSONObject;
import com.shop.common.entity.goods.GoodsInfo;
import com.shop.common.entity.order.OrderDO;
import com.shop.common.entity.order.OrderInfo;
import com.shop.common.entity.user.LoginUserInfo;
import com.shop.common.entity.user.UserInfo;
import org.springframework.beans.BeanUtils;


/**
 * @author
 * @version $Id: CovertorUtils.java,v 0.1 2021/7/5 16:28  Exp $
 */
public class CovertorUtils {

    public static OrderInfo covertorOrderDoToInfo(OrderDO orderDO){

        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderDO, orderInfo);
        orderInfo.setGoodsInfo(JSONObject.parseObject(orderDO.getGoodsInfoStr(), GoodsInfo.class));
        return orderInfo;

    }

    public static OrderDO covertorOrderInfoToDo(OrderInfo orderInfo){
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderInfo, orderDO);
        orderDO.setGoodsInfoStr(JSONObject.toJSONString(orderInfo.getGoodsInfo()));
        return orderDO;

    }

    public static LoginUserInfo userInfoToLongUserInfo(UserInfo userInfo){

        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setUid(userInfo.getUid());
        loginUserInfo.setName(userInfo.getName());
        loginUserInfo.setSource(userInfo.getSource());

        return loginUserInfo;

    }

}
