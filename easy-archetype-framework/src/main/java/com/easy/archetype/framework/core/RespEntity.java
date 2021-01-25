package com.easy.archetype.framework.core;

import com.easy.archetype.framework.spring.SpringContextHolder;
import com.easy.archetype.framework.spring.message.MessageUtils;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;


/**
 * 统一返回
 *
 * @author luyanan
 * @since 2021/1/17
 **/
@Data
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


    /**
     * 成功返回
     *
     * @param data 返回的数据
     * @return com.easy.archetype.framework.core.RespEntity<T>
     * @since 2021/1/24
     */
    public static <T> RespEntity<T> success(T data) {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.setData(data);
        respEntity.setStatus("200");
        return respEntity;
    }


    /**
     * 异常信息
     *
     * @param code
     * @return com.easy.archetype.framework.core.RespEntity<T>
     * @since 2021/1/24
     */
    public static <T> RespEntity<T> error(String code, Object... args) {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.setStatus(code);
        respEntity.setMsg(MessageUtils.getMessage(code, args));
        HttpServletRequest request = SpringContextHolder.getRequest();
        respEntity.setTimestamp(System.currentTimeMillis());
        if (null != request) {
            respEntity.setPath(request.getRequestURI());
        }
        return respEntity;
    }

}
