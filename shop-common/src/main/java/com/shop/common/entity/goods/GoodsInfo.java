package com.shop.common.entity.goods;

import com.shop.common.entity.base.BaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @version $Id: GoodsInfo.java,v 0.1 2021/7/2 13:27  Exp $
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo extends BaseInfo {

    private String gid;

    private String name;

    private Integer count;
}
