package com.shop.common.entity.order;

import com.shop.common.entity.base.BaseInfo;
import com.shop.common.entity.goods.GoodsInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author
 * @version $Id: OrderInfo.java,v 0.1 2021/7/2 15:10  Exp $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo extends BaseInfo {

    private String          oid;

    private String          name;

    private GoodsInfo       goodsInfo;


}
