package com.easy.archetype.framework.configcenter;

import com.easy.archetype.framework.config.EasyArchetypeFrameworkProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 配置中心自动配置类
 *
 * @author luyanan
 * @since 2021/1/29
 **/
@ConditionalOnWebApplication
@ConditionalOnClass(ContextRefresher.class)
@ConditionalOnProperty(prefix = ConfigCenterProperties.PREFIX, name = "enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(ConfigCenterProperties.class)
@Configuration
public class ConfigCenterConfiguration {


    @ConditionalOnBean(PropertySource.class)
    @Bean
    public ConfigCenter configCenter(PropertySource propertySource, ContextRefresher contextRefresher, ConfigurableEnvironment configurableEnvironment) {
        ConfigCenter configCenter = new ConfigCenter(propertySource, contextRefresher, configurableEnvironment);
        configCenter.mergeProperties();
        return configCenter;
    }

}
