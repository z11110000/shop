package com.shop.common.entity.base;

/**
 * @author
 * @version $Id: BaseConstant.java,v 0.1 2021/7/5 14:13  Exp $
 */
public class Constant {

    /**
     * rabbitmq交换机名称(临时)
     */
    public static final String EXCHANGE_NAME =      "TEST_EXCHANGE";

    /**
     * rabbitmq队列名称(临时)
     */
    public static final String QUEUE_NAME =         "TEST_QUEUE_KEY";

    /**
     * rabbitmq路由名称(临时)
     */
    public static final String ROUTING_KEY =        "TEST_ROUTING_KEY";

    /**
     * 在线用户前缀
     */
    public static final String ONLINE_USER_PREFIX = "online_user_";

    public static final String ONLINE_USER_ADMIN_PREFIX = "online_user_admin";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX =       "Beaer ";

    public static final String LOGIN_TOKEN_KEY =    "login_token:";

    public static final Long MILLIS_SECOND =        1000L;

    public static final Long MILLIS_MINUTE =        60 * MILLIS_SECOND;

    public static final Long TWENTY_LONG =          20L;

    public static final Long THREETY_LONG =         30L;


}
