package com.shop.user.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.shop.common.entity.base.Constant;
import com.shop.common.entity.user.LoginUserInfo;
import com.shop.middleware.cache.RedisCache;
import com.shop.user.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Reference
    private RedisCache redisCache;

    @Value("${token.secret}")
    private String secret;

    @Override
    public String createToken(LoginUserInfo loginUserInfo) {

        String token = getTokenKey(loginUserInfo.getUid(), loginUserInfo.getSource());
        redisCache.setCacheObject(token, loginUserInfo);

        Map<String, Object> claims = new HashMap<>();
        claims.put(Constant.LOGIN_TOKEN_KEY, token);

        LOGGER.info("创建令牌: {}", loginUserInfo);

        return createToken(claims);
    }

    private String createToken(Map<String, Object> claims){

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }


    public String getTokenKey(String uuid, String source){

        if (Constant.ONLINE_USER_ADMIN_PREFIX.contains(source)){
            return Constant.ONLINE_USER_ADMIN_PREFIX.concat(uuid);
        }

        return Constant.ONLINE_USER_PREFIX.concat(uuid);

    }

}
