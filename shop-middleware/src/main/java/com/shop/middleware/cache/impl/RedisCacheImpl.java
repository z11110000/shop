package com.shop.middleware.cache.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.middleware.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheImpl implements RedisCache {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public <T> void setCacheObject(String key, T value) {

        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public <T> void setCacheObject(String key, T value, Integer timeOut, TimeUnit timeUnit) {

        redisTemplate.opsForValue().set(key, value, timeOut, timeUnit);
    }

    @Override
    public <T> T getCacheObject(String key) {

        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        return operations.get(key);

    }
}
