package com.shop.middleware.mq;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.common.entity.base.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: ProductImpl.java,v 0.1 2021/7/5 14:21  Exp $
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    RabbitMqConnection connection;

    @Override
    public void basicPublish(String str) throws IOException, TimeoutException {

        connection.getChannel().basicPublish(Constant.EXCHANGE_NAME,
                Constant.ROUTING_KEY,
                null, str.getBytes());

    }
}
