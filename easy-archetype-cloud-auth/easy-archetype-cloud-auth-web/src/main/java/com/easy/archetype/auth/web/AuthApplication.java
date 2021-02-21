package com.easy.archetype.auth.web;

import com.easy.archetype.security.oauth.client.annotation.EnableOauthClient;
import com.easy.archetype.security.oauth.server.annotation.EnableOauthServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 授权启动类
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@EnableOauthClient
@EnableOauthServer
@SpringCloudApplication
@SpringBootApplication
public class AuthApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
