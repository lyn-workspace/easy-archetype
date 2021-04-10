package com.easy.archetype.data.config;

import com.easy.archetype.data.cache.RedisCacheAutoConfiguration;
import com.easy.archetype.data.configcenter.ConfigCenterAutoConfiguration;
import com.easy.archetype.data.logger.LoggerAutoConfiguration;
import com.easy.archetype.data.mybatisplus.MybatisPlusConfiguration;
import com.easy.archetype.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 数据模块的自动装配
 *
 * @author luyanan
 * @since 2021/3/15
 **/
@Configuration
@EnableConfigurationProperties(EasyArchetypeDataProperties.class)
@ConditionalOnProperty(prefix = EasyArchetypeDataProperties.PREFIX, name = "enable", havingValue = "true",
		matchIfMissing = true)
@Import({RedisCacheAutoConfiguration.class,
		ConfigCenterAutoConfiguration.class,
		LoggerAutoConfiguration.class,
		ConfigCenterAutoConfiguration.class,
		MybatisPlusConfiguration.class,
		RedisAutoConfiguration.class
})
public class EasyArchetypeDataAutoConfiguration {
}
