package com.easy.archetype.framework.logger;

/**
 * 日志处理器
 *
 * @author luyanan
 * @since 2021/1/23
 **/
public interface LoggerHandler {

    /**
     * 日志的处理类
     *
     * @param loggerVo
     * @return void
     * @since 2021/1/23
     */
    void handler(LoggerVo loggerVo);

}
