package com.shop.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author
 * @version $Id: EnumSystemName.java,v 0.1 2021/7/7 16:11  Exp $
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SystemNameEnum {

    MIDDLEWARE("001", "middleware", "中间件服务系统"),
    GOODS("002", "goods", "商品系统"),
    ORDERS("003", "orders", "订单系统"),
    USER("004", "users", "用户系统"),
    ACTIVE("005", "active", "活动系统"),
    ADMIN("006", "admin", "后台管理系统"),
    ;

    private String code;

    private String enligshName;

    private String chineseName;




}
