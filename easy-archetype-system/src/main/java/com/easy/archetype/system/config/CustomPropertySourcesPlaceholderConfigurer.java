package com.easy.archetype.system.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PropertyPlaceholderHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 自定义PropertySourcesPlaceholderConfigurer
 *
 * @author luyanan
 * @since 2021/1/25
 **/
@Slf4j
@Component
public class CustomPropertySourcesPlaceholderConfigurer extends PropertyPlaceholderConfigurer {


    @Override
    protected Properties mergeProperties() throws IOException {
        Properties properties = super.mergeProperties();

        log.info("CustomPropertySourcesPlaceholderConfigurer");
//        properties.putAll(this.billyexConfigCenter.getProperties());
//        this.logger.debug("mergeProperties()={}", properties.toString());
//        this.billyexConfigCenter.close();
        // TODO 可以借此做配置中心
//        properties.put("name", "111");
        return properties;
    }
}
