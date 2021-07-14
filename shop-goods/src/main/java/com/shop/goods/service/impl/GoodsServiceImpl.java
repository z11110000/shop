package com.shop.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.shop.goods.mapper.GoodsMapper;
import com.shop.goods.service.GoodsService;
import com.shop.middleware.mq.ConsumerService;
import com.shop.common.entity.goods.GoodsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author
 * @version $Id: GoodsService.java,v 0.1 2021/7/2 13:39  Exp $
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Reference
    private ConsumerService consumerService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public GoodsInfo getGoodsInfo(String gid) {
        return goodsMapper.select(gid);
    }

    @Transactional
    @Override
    public int subGoodsCount(GoodsInfo goodsInfo) {

        LOGGER.info("商品减库存: {}", goodsInfo);

        int update = goodsMapper.update(goodsInfo);

        return update;
    }

    @Override
    public GoodsInfo addGoodsInfo(GoodsInfo goodsInfo) {

        goodsInfo = new GoodsInfo(UUID.randomUUID().toString().replace("-", ""), "手机", 10000);

        goodsMapper.insert(goodsInfo);

        return goodsInfo;
    }
}
