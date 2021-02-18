package com.easy.archetype.security.security;

import com.easy.archetype.security.core.IgnoringLoginScanner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * web security自动配置
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
@Import(WebSecurityConfig.class)
public class WebSecurityAutoConfiguration {

	/**
	 * 密码编解码器
	 *
	 * @return org.springframework.security.crypto.password.PasswordEncoder
	 * @since 2021/2/18
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public IgnoringLoginScanner ignoringLoginScanner() {
		return new IgnoringLoginScanner();
	}

}
