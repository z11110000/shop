package com.shop.admin.result;

import com.shop.common.entity.enums.SysResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面返回
 */
@Data
@NoArgsConstructor
public class WebResult<T> extends BaseResult{

    private T           resultSet;

    public WebResult(SysResultCodeEnum result, String errMsg) {
        this.code = result.getCode();
        this.des = result.getChineseName();
        this.errMsg = errMsg;
    }

    public WebResult(T resultSet) {
        this.code = SysResultCodeEnum.SUCCESS.getCode();
        this.des = SysResultCodeEnum.SUCCESS.getDes();
        this.resultSet = resultSet;
    }

    public WebResult(String des, T resultSet){

        this.code = SysResultCodeEnum.SUCCESS.getCode();
        this.des = des;
        this.resultSet = resultSet;

    }

    public WebResult(String code, String des, String errMsg, T resultSet) {
        super(code, des, errMsg);
        this.resultSet = resultSet;
    }
}
