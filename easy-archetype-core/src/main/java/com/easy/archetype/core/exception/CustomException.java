package com.easy.archetype.core.exception;

/**
 * <p>自定义异常</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;


    public CustomException(MsgCode msgCode) {
        this.message = msgCode.getMsg();
        this.code = msgCode.getCode();

    }


    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
