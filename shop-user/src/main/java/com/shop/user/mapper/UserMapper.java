package com.shop.user.mapper;

import com.shop.common.entity.user.UserInfo;

/**
 * @version $Id: UserMapper.java,v 0.1 2021/7/7 16:24  Exp $
 */
public interface UserMapper {

    int addUser(UserInfo userInfo);

    UserInfo getUserInfo(UserInfo userInfo);

}
