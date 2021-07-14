package com.shop.common.entity.active;

import com.shop.common.entity.base.BaseInfo;
import com.shop.common.entity.order.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author
 * @version $Id: ActiveInfo.java,v 0.1 2021/7/2 15:32  Exp $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveInfo extends BaseInfo {

    private String              name;

    private List<OrderInfo>     orderInfoList;
}
