package com.easy.archetype.security.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * HttpSecurity的安全访问配置
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@FunctionalInterface
public interface HttpSecurityConfigHandler {

	/**
	 * 安全配置
	 *
	 * @param http
	 * @return void
	 * @throws Exception
	 * @since 2021/2/18
	 */
	void handler(HttpSecurity http) throws Exception;


}
