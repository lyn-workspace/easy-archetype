package com.easy.archetype.system.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 自定义PropertySourcesPlaceholderConfigurer
 *
 * @author luyanan
 * @since 2021/1/25
 **/
@Configuration
public class CustomPropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {
    private static Map<String, String> properties = new HashMap<String, String>();

    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        properties.put("name", "aaa");
        // cache the properties
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper(
                DEFAULT_PLACEHOLDER_PREFIX, DEFAULT_PLACEHOLDER_SUFFIX, DEFAULT_VALUE_SEPARATOR, false);
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            String stringKey = String.valueOf(entry.getKey());
            String stringValue = String.valueOf(entry.getValue());
            stringValue = helper.replacePlaceholders(stringValue, props);
            properties.put(stringKey, stringValue);
        }
        super.processProperties(beanFactoryToProcess, props);
    }


}
