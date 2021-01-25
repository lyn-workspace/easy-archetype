package com.easy.archetype.framework.logger;

import com.easy.archetype.framework.config.EasyArchetypeFrameworkProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 日志自动化配置
 *
 * @author luyanan
 * @since 2021/1/22
 **/
@ConditionalOnProperty(prefix = EasyArchetypeFrameworkProperties.PREFIX, name = "logger.enable", havingValue = "true", matchIfMissing = true)
@EnableAsync
@RequiredArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LoggerAutoConfiguration {

    @Bean
    public LoggerListener loggerListener() {
        return new LoggerListener();
    }

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }

    @Bean
    public ApplicationLoggerInitializer applicationLoggerInitializer() {
        return new ApplicationLoggerInitializer();
    }
}
