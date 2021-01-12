package com.easy.archetype.core.exception;

/**
 * <p>消息编码</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public enum MsgCode {
    ;

    private Integer code;

    private String msg;


    MsgCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    /**
     * <p>获取异常信息</p>
     *
     * @param args
     * @return {@link String}
     * @author luyanan
     * @since 2021/1/12
     */
    public String getMsg(Object... args) {
        return msg;
    }
}
