package com.shop.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.active.serivce.ActiveService;
import com.shop.common.entity.active.ActiveInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @version $Id: ActiveController.java,v 0.1 2021/7/2 15:34  Exp $
 */
@RestController
@RequestMapping("/active")
public class ActiveController {


    @Reference
    private ActiveService activeService;


    @GetMapping("getActive")
    public ActiveInfo getActive(){
        return activeService.getActiveInfo();
    }

}
