package com.easy.archetype.framework.config;

import com.easy.archetype.framework.spring.SpringAutoConfiguration;
import com.easy.archetype.framework.thread.BusinessThreadPoolAutoConfiguration;
import com.easy.archetype.framework.xss.XssAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 自动配置
 *
 * @author luyanan
 * @since 2021/1/20
 **/
@ConditionalOnProperty(prefix = EasyArchetypeFrameworkProperties.PREFIX, name = "enable", havingValue = "true",
		matchIfMissing = true)
@EnableConfigurationProperties({EasyArchetypeFrameworkProperties.class})
@Configuration

@Import({
		SpringAutoConfiguration.class,
		BusinessThreadPoolAutoConfiguration.class,
		XssAutoConfiguration.class


})
public class EasyArchetypeFrameworkAutoConfiguration {

}
