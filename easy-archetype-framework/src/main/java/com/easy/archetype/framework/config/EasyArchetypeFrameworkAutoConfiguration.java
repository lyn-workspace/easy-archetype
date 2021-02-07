package com.easy.archetype.framework.config;

import com.easy.archetype.framework.spring.SpringContextHolder;
import com.easy.archetype.framework.thread.BusinessThreadPoolProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置
 *
 * @author luyanan
 * @since 2021/1/20
 **/
@ConditionalOnProperty(prefix = EasyArchetypeFrameworkProperties.PREFIX, name = "enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties({EasyArchetypeFrameworkProperties.class})
@ComponentScan("com.easy.archetype.framework")
@Configuration
public class EasyArchetypeFrameworkAutoConfiguration {


}
