package com.shop.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.common.entity.user.LoginUserInfo;
import com.shop.common.entity.user.UserInfo;
import com.shop.common.entity.utils.AssertUtils;
import com.shop.user.mapper.UserMapper;
import com.shop.user.service.TokenService;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @version $Id: UserServiceImpl.java,v 0.1 2021/7/7 16:23  Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    @Transactional
    @Override
    public UserInfo register(UserInfo userInfo) {

        AssertUtils.notEmpty(userInfo.getSource(), "用户注册来源不能为空");

        //查看用户名是否已存在
        UserInfo info = userMapper.getUserInfo(new UserInfo(userInfo.getName()));
        AssertUtils.isNull(info, "用户名已存在");

        userInfo.setUid(UUID.randomUUID().toString().replace("-", ""));
        userMapper.addUser(userInfo);
        return userInfo;
    }

    @Override
    public String login(LoginUserInfo loginUserInfo) {

        UserInfo userInfo = userMapper.getUserInfo(
                new UserInfo(loginUserInfo.getName(), loginUserInfo.getPassword(), loginUserInfo.getSource()));
        AssertUtils.notNull(userInfo, "用户不存在");
        loginUserInfo.setUid(userInfo.getUid());

        String token = tokenService.createToken(loginUserInfo);

        return token;

    }

}
