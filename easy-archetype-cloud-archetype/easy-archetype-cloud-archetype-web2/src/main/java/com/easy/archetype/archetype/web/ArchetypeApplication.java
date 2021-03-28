package com.easy.archetype.archetype.web;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author luyanan
 * @since 2021/3/28
 **/
@SpringCloudApplication
@EnableFeignClients
public class ArchetypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchetypeApplication.class, args);
	}
}
