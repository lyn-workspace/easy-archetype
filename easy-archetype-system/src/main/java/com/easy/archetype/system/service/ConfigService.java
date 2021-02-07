package com.easy.archetype.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 配置类
 * html调用 thymeleaf 实现参数管理
 *
 * @author luyanan
 * @since 2021/1/24
 **/
@Service("config")
public class ConfigService {
    /**
     * 业务配置前缀
     *
     * @since 2021/1/24
     */

    @Autowired
    private Environment environment;

    /**
     * 根据key获取参数配置信息
     *
     * @param configKey key
     * @return java.lang.String
     * @since 2021/1/24
     */
    public String getKey(String configKey) {
        return environment.getProperty(configKey);
    }

}
