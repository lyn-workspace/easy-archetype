package com.easy.archetype.web;

import com.easy.archetype.security.oauth.client.annotation.EnableOauthClient;
import com.easy.archetype.security.oauth.server.annotation.EnableOauthServer;
import com.easy.archetype.security.security.annotation.EnableSecurity;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * <p>
 * 主启动类
 * </p>
 *
 * @author luyanan
 * @since 2021/1/18
 **/
@EnableKnife4j
@EnableOauthClient
@EnableOauthServer
//@EnableSecurity
@EnableCaching
@SpringBootApplication
public class ApeHubWenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApeHubWenApplication.class, args);
    }

}
