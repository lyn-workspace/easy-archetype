package com.easy.archetype.core.exception;

/**
 * <p>消息编码</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public enum MsgCode {
    // 请求方式不支持
    REQUEST_METHOD_NOT_SUPPORTED("405", "Request method '{0}' not supported,url:{1}"),
    // 网络异常
    NETWORK_ERROR("500", "网络异常"),
    METHOD_ARGUMENT_NOT_VALID("400", "请求参数错误"),

    UNAUTHORIZED("401", "请重新登陆"),

    ;
    private String code;

    private String msg;


    MsgCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
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
