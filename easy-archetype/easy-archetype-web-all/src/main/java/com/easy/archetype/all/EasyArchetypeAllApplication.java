package com.easy.archetype.all;

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
@EnableSecurity
@EnableCaching
@SpringBootApplication
public class EasyArchetypeAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyArchetypeAllApplication.class, args);
	}

}
