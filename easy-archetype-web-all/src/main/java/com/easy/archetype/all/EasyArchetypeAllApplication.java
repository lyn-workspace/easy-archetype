package com.easy.archetype.all;

import com.easy.archetype.framework.cache.CacheConfig;
import com.easy.archetype.framework.config.EasyArchetypeFrameworkProperties;
import com.easy.archetype.framework.logger.LoggerAspect;
import com.easy.archetype.framework.spring.SpringContextHolder;
import com.easy.archetype.framework.thread.BusinessThreadPoolTaskExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <p>主启动类</p>
 *
 * @author luyanan
 * @since 2021/1/18
 **/
@EnableCaching
@SpringBootApplication
public class EasyArchetypeAllApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyArchetypeAllApplication.class, args);
    }
}
