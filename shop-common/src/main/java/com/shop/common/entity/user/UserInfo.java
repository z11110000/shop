package com.shop.common.entity.user;

import com.shop.common.entity.base.BaseInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version $Id: UserInfo.java,v 0.1 2021/7/7 16:06  Exp $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseInfo {

    private String uid;

    private String name;

    private String password;

    private String source;

    public UserInfo(String name) {
        this.name = name;
    }

    public UserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserInfo(String name, String password, String source) {
        this.name = name;
        this.password = password;
        this.source = source;
    }
}
