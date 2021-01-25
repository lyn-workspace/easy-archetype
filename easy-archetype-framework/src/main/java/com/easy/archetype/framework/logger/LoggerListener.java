package com.easy.archetype.framework.logger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 日志监听者
 *
 * @author luyanan
 * @since 2021/1/22
 **/
@Slf4j
@RequiredArgsConstructor
public class LoggerListener {



    @Async
    @Order
    @EventListener
    public void listener(LoggerEvent loggerEvent) {
        LoggerVo loggerVo = (LoggerVo) loggerEvent.getSource();

    }
}
