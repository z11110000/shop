package com.shop.common.entity.user;

import com.shop.common.entity.base.BaseInfo;
import lombok.Data;

@Data
public class LoginUserInfo extends BaseInfo {

    private String      uid;

    private String      name;

    private String      password;

    private String      ipAddr;

    private String      loginLocal;

    private String      source;

    private String      brower;

    private String      os;

    private Long        loginTime;

    private Long        lastTime;

    private Long        expireTime;


}
