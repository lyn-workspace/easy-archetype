package com.easy.archetype.framework.config;

import com.easy.archetype.framework.cache.RedisCacheAutoConfiguration;
import com.easy.archetype.framework.configcenter.ConfigCenterAutoConfiguration;
import com.easy.archetype.framework.logger.LoggerAutoConfiguration;
import com.easy.archetype.framework.mybatisplus.MybatisPlusConfiguration;
import com.easy.archetype.framework.redis.RedisAutoConfiguration;
import com.easy.archetype.framework.spring.SpringAutoConfiguration;
import com.easy.archetype.framework.spring.SpringContextHolder;
import com.easy.archetype.framework.thread.BusinessThreadPoolAutoConfiguration;
import com.easy.archetype.framework.thread.BusinessThreadPoolProperties;
import com.easy.archetype.framework.xss.XssAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

@Import({RedisCacheAutoConfiguration.class,
		ConfigCenterAutoConfiguration.class,
		LoggerAutoConfiguration.class,
		ConfigCenterAutoConfiguration.class,
		MybatisPlusConfiguration.class,
		RedisAutoConfiguration.class,
		SpringAutoConfiguration.class,
		BusinessThreadPoolAutoConfiguration.class,
		XssAutoConfiguration.class


})
public class EasyArchetypeFrameworkAutoConfiguration {

}
