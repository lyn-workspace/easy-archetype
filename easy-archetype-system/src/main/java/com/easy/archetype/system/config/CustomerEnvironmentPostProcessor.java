package com.easy.archetype.system.config;

import cn.hutool.core.util.RandomUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义配置
 *
 * @author luyanan
 * @since 2021/1/26
 **/
public class CustomerEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private static final String PROPERTY_SOURCE_NAME = "defaultProperties";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", "11");
        addOrReplace(environment.getPropertySources(), map, PROPERTY_SOURCE_NAME);
    }

    public static void addOrReplace(MutablePropertySources propertySources, Map<String, Object> map, String propertySourceName) {
        MapPropertySource target = null;

        PropertiesPropertySource propertiesPropertySource = (PropertiesPropertySource) propertySources.get("systemProperties");
        propertiesPropertySource.getSource().put("name", RandomUtil.randomInt(10));
        propertySources.replace("systemProperties", propertiesPropertySource);
        if (propertySources.contains(propertySourceName)) {
            PropertySource<?> source = propertySources.get(propertySourceName);
            if (source instanceof MapPropertySource) {
                target = (MapPropertySource) source;
                target.getSource().put("name", "222");
                for (String key : map.keySet()) {
                    if (!target.containsProperty(key)) {
                        target.getSource().put(key, map.get(key));
                    }
                }
            }
        }
        if (target == null) {
            target = new MapPropertySource(propertySourceName, map);
        }
        if (!propertySources.contains(propertySourceName)) {
            propertySources.addLast(target);
        }
    }
}
