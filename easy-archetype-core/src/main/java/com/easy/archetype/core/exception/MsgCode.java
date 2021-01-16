package com.easy.archetype.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>消息编码</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
@AllArgsConstructor
@Getter
public enum MsgCode {


//
//    SUCCESS("200","成功",""),
//
//    HTTP_BAD_REQUEST("400","HTTP_BAD_REQUEST",""),
//
//    HTTP_UNAUTHORIZED("401","HTTP_UNAUTHORIZED"),
//
//    HTTP_FORBIDDEN("403","HTTP_FORBIDDEN"),
//
//    HTTP_NOT_FOUND("404","HTTP_NOT_FOUND"),
//
//    HTTP_BAD_METHOD("405","HTTP_BAD_METHOD"),
//
//    HTTP_INTERNAL_ERROR("500","HTTP_INTERNAL_ERROR");

    ;
    /**
     * <p>错误编码 </p>
     *
     * @author luyanan
     * @since 2021/1/16
     */
    private String errorCode;

    /**
     * <p>错误信息</p>
     *
     * @author luyanan
     * @since 2021/1/16
     */
    private String errorMsg;

    /**
     * <p>提示信息</p>
     *
     * @author luyanan
     * @since 2021/1/16
     */
    private String userTip;


}
