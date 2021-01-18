package com.easy.archetype.core.exception;

import cn.hutool.core.lang.Assert;

/**
 * <p>自定义异常</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomException(IMsgCode msgCode) {
        super("{code:" + msgCode.getErrorCode() + "},{message:{" + msgCode.getErrorMsg() + "}");
        Assert.isNull("msgCode", "msgCode 不能为空");
    }

}
