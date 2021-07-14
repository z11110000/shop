package com.shop.goods.service;

import com.shop.common.entity.goods.GoodsInfo;

/**
 * @author
 * @version $Id: GoodsService.java,v 0.1 2021/7/2 13:27  Exp $
 */
public interface GoodsService {

    GoodsInfo getGoodsInfo(String gid);

    int subGoodsCount(GoodsInfo goodsInfo);

    GoodsInfo addGoodsInfo(GoodsInfo goodsInfo);

}
