package com.shop.middleware.mq;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.common.entity.base.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: ConsumerServiceImpl.java,v 0.1 2021/7/5 14:53  Exp $
 */
@Service
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    RabbitMqConnection connection;

    @Override
    public String basicConsumer() throws IOException, TimeoutException {

        return connection.getChannel().basicConsume(Constant.QUEUE_NAME, true, null);
    }
}
