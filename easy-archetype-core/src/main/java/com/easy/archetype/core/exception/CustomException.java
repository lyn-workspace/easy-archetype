package com.easy.archetype.core.exception;

/**
 * <p>自定义异常</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomException(MsgCode msgCode) {
        super("{code:" + msgCode.getErrorCode() + "},{message:{" + msgCode.getErrorMsg() + "}");

    }

}
