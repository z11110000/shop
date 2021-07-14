package com.shop.user.service;

import com.shop.common.entity.user.LoginUserInfo;
import com.shop.common.entity.user.UserInfo;


/**
 * @version $Id: UserService.java,v 0.1 2021/7/7 16:22  Exp $
 */
public interface UserService {

    UserInfo register(UserInfo userInfo);

    String login(LoginUserInfo loginUserInfo);

}
