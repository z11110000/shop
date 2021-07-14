package com.shop.middleware.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @version $Id: Product.java,v 0.1 2021/7/5 9:52  Exp $
 */
public interface ProductService {

    void basicPublish(String str) throws IOException, TimeoutException;

}
