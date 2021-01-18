package com.easy.archetype.core.exception;

/**
 * <p>消息编码的接口类</p>
 *
 * @author luyanan
 * @since 2021/1/17
 **/
public interface IMsgCode {


    /**
     * 获取编码
     *
     * @return java.lang.String
     * @date 2021/1/18
     */
    String getErrorCode();

    /**
     * 获取异常信息
     *
     * @return java.lang.String
     * @date 2021/1/18
     */
    String getErrorMsg();

    /**
     * 获取用户提示信息
     *
     * @return java.lang.String
     * @date 2021/1/18
     */
    String getUserTip();
}
