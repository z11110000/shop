package com.shop.admin.result;

import com.shop.common.entity.enums.SysResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -915254376580732826L;

    public String       code;

    public String       des;

    public String       errMsg;

    public BaseResult(SysResultCodeEnum result, String errMsg) {
        this.code = result.getCode();
        this.des = result.getChineseName();
        this.errMsg = errMsg;
    }
}
