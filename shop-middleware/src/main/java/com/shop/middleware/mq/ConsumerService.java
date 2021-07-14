package com.shop.middleware.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: ConsumerService.java,v 0.1 2021/7/5 14:53  Exp $
 */
public interface ConsumerService {

    String basicConsumer() throws IOException, TimeoutException;

}
