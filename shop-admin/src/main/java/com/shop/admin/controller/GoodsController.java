package com.shop.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.goods.service.GoodsService;
import com.shop.common.entity.goods.GoodsInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @version $Id: GoodsController.java,v 0.1 2021/7/2 14:38  Exp $
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    @GetMapping("/getGoodsInfo")
    public GoodsInfo getGoodsInfo(){

        return goodsService.getGoodsInfo("111");
    }

    @PostMapping("/addGoodsInfo")
    public GoodsInfo addGoodsInfo(){

        return goodsService.addGoodsInfo(null);
    }

}
