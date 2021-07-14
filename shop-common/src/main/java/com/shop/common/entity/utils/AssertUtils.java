package com.shop.common.entity.utils;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.util.ObjectUtils;

public class AssertUtils {


    public static void notEmpty(String str, String errMsg){

        isTrue(StringUtils.isNotEmpty(str), errMsg);

    }

    public static void isNull(Object obj, String errMsg){

        isTrue(ObjectUtils.isEmpty(obj), errMsg);

    }


    public static void notNull(Object obj, String errMsg){

        isTrue(!ObjectUtils.isEmpty(obj), errMsg);

    }

    public static void isTrue(Boolean boo, String errMsg){

        if (!boo){
            throw new RuntimeException(errMsg);
        }
    }


}
