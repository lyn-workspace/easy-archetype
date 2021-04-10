package com.easy.archetype.auth.api.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * feign的自动注入
 *
 * @author luyanan
 * @since 2021/2/21
 **/
@ComponentScan("com.easy.archetype.auth.api")
@Configuration
@EnableFeignClients(basePackages = "com.easy.archetype.auth.api.api")
public class FeignClientAutoConfiguration {
}
