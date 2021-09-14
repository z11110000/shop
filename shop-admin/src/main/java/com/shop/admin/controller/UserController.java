package com.shop.admin.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.admin.result.WebResult;
import com.shop.common.entity.base.Constant;
import com.shop.common.entity.enums.SystemNameEnum;
import com.shop.common.entity.user.LoginUserInfo;
import com.shop.common.entity.user.UserInfo;
import com.shop.common.entity.utils.AssertUtils;
import com.shop.common.entity.utils.CovertorUtils;
import com.shop.common.entity.utils.RequestUtils;
import com.shop.user.service.UserService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Reference
    private UserService userService;

    /**
     * 用户注册
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/register.json")
    public WebResult register(String name, String password){

        AssertUtils.isTrue(!StringUtils.isEmpty(name) && !StringUtils.isEmpty(password), "用户名和密码不能为空");

        UserInfo userInfo = new UserInfo(name, password, SystemNameEnum.ADMIN.getEnligshName());
        userInfo = userService.register(userInfo);
        LoginUserInfo loginUserInfo = CovertorUtils.userInfoToLongUserInfo(userInfo);

        LOGGER.info("用户注册成功, info: {}", loginUserInfo);

        return new WebResult("注册成功", loginUserInfo);

    }

    /**
     * 登陆
     * @return
     */
    @PostMapping("/login.json")
    public WebResult login(LoginUserInfo loginUserInfo){

        AssertUtils.isTrue(!StringUtils.isEmpty(loginUserInfo.getName())
                && !StringUtils.isEmpty(loginUserInfo.getPassword()), "用户名和密码不能为空");


        assembleLoginUserInfo(loginUserInfo);
        String token = userService.login(loginUserInfo);

        return new WebResult("登录成功", token);
    }

    private LoginUserInfo assembleLoginUserInfo(LoginUserInfo loginUserInfo){

        UserAgent userAgent = UserAgent.parseUserAgentString(RequestUtils.getRequest().getHeader("User-Agent"));
        String ipAddress = RequestUtils.getRealIpAddress(RequestUtils.getRequest());
        loginUserInfo.setIpAddr(ipAddress);
        //loginUserInfo.setBrower(userAgent.getBrowser().getName().concat(userAgent.getBrowserVersion().getVersion()));
        loginUserInfo.setOs(userAgent.getOperatingSystem().getName());
        loginUserInfo.setLoginTime(System.currentTimeMillis());
        loginUserInfo.setExpireTime(loginUserInfo.getLoginTime() * Constant.TWENTY_LONG * Constant.MILLIS_MINUTE);
        loginUserInfo.setSource(SystemNameEnum.ADMIN.getEnligshName());

        return loginUserInfo;

    }

}
