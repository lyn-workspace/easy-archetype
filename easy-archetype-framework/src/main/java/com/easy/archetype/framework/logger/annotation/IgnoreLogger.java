package com.easy.archetype.framework.logger.annotation;

import java.lang.annotation.*;

/**
 * 忽略日志注解
 *
 * @author luyanan
 * @since 2021/1/22
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreLogger {

    /**
     * 忽略类型,默认全部忽略
     *
     * @return com.easy.archetype.framework.logger.annotation.IgnoreLogger.IgnoreLoggerType
     * @since 2021/1/22
     */
    IgnoreLoggerType type() default IgnoreLoggerType.ALL;

    /**
     * 忽略日志类型
     *
     * @author luyanan
     * @since 2021/1/24
     */
    public enum IgnoreLoggerType {
        /**
         * 忽略请求参数
         *
         * @since 2021/1/22
         */
        Params,
        /**
         * 忽略返回结果
         *
         * @author luyanan
         * @since 2021/1/22
         */
        Result,
        /**
         * 全部忽略
         *
         * @author luyanan
         * @since 2021/1/22
         */
        ALL;
    }
}
