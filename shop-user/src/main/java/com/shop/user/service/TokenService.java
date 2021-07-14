package com.shop.user.service;

import com.shop.common.entity.user.LoginUserInfo;

/**
 * 令牌服务
 */
public interface TokenService {

    String createToken(LoginUserInfo userInfo);

}
