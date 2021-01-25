package com.easy.archetype.framework.logger;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * web日志打印
 *
 * @author luyanan
 * @since 2021/1/23
 **/
@Slf4j
public class WebLoggerHandlerPrint extends AbstractLoggerHandler {
    @Override
    protected void handler(LoggerVo loggerVo, Map<String, Object> loggerData) {

        StringBuilder logger = new StringBuilder();
        logger.append("[--------------------------------------------------\n");
        logger.append("methodName:").append(loggerData.get("methodName")).append("\n");
        logger.append("desp:").append(loggerData.get("desp")).append("\n");
        logger.append("uri:").append(loggerData.get("uri")).append("\n");
        logger.append("sourceIp:").append(loggerData.get("sourceIp")).append("\n");
        logger.append("params:").append(loggerData.get("params")).append("\n");
        logger.append("result:").append(loggerData.get("result")).append("\n");
        logger.append("time:").append("elapsedTime").append("\n");
        logger.append("-----------------------------------------------------]");
        log.debug(logger.toString());
    }
}
