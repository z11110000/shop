package com.shop.middleware.cache;

import java.util.concurrent.TimeUnit;

/**
 * redis缓存服务
 */
public interface RedisCache {

    <T> void setCacheObject(final String key, final T value);

    <T> void setCacheObject(final String key, final T value, final Integer timeOut, final TimeUnit timeUnit);

    <T> T getCacheObject(final String key);
}
