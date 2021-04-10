package com.easy.archetype.archetype.web;

import com.easy.archetype.security.oauth.client.annotation.EnableOauthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 脚手架启动类
 *
 * @author luyanan
 * @since 2021/2/21
 **/
@EnableOauthClient
@SpringCloudApplication
@EnableFeignClients
public class ArchetypeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArchetypeApplication.class, args);
	}
}
