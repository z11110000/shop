package com.shop.common.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SysResultCodeEnum {

    SUCCESS("0000", "sucess", "成功", "成功"),

    SYSTEM_ERROR("1000", "serverError", "业务异常", "业务异常"),

    SERVER_ERROR("1001", "serverError", "业务异常", "业务异常"),

    USER_NAME_NULL_ERROR("1002", "userNameNull", "用户名不能为空", "用户名不能为空"),

    USER_PASSWORD_NULL_ERROR("1003", "userPasswordNull", "密码不能为空", "密码不能为空"),

    USER_NAME_AND_PASSWORD_NULL_ERROR("1004", "userNameAndPasswordNull", "用户名和密码不能为空", "用户名和密码不能为空"),
    ;

    private String  code;

    private String  enName;

    private String  chineseName;

    private String  des;

    public String getCode() {
        return code;
    }

    public String getEnName() {
        return enName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public String getDes() {
        return des;
    }
}
