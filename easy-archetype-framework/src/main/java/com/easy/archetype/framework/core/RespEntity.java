package com.easy.archetype.core.core;

import java.io.Serializable;


/**
 * 统一返回
 *
 * @author luyanan
 * @since 2021/1/17
 **/

public class RespEntity<T> implements Serializable {
    private static final long serialVersionUID = 1996369589258128651L;


    /**
     * <p>返回状态码</p>
     *
     * @since 2021/1/17
     */
    private String status;


    /**
     * <p>消息</p>
     *
     * @since 2021/1/17
     */
    private String msg;

    /**
     * <p>返回的数据</p>
     *
     * @since 2021/1/17
     */
    private T data;

    /**
     * <p>错误时间戳</p>
     *
     * @since 2021/1/17
     */
    private Long timestamp;

    /**
     * <p>错误路径</p>
     *
     * @since 2021/1/17
     */
    private String path;
}
