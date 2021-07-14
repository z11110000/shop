package com.shop.goods.mapper;

import com.shop.common.entity.goods.GoodsInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @version $Id: GoodDao.java,v 0.1 2021/7/5 15:56  Exp $
 */
public interface GoodsMapper {

    int insert(GoodsInfo goodsInfo);

    int update(GoodsInfo goodsInfo);

    GoodsInfo select(@Param("gid")String gid);

}
