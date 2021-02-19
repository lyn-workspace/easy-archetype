package com.easy.archetype.security.security;

import cn.hutool.core.collection.CollectionUtil;
import com.easy.archetype.security.core.IgnoringLoginScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * web security配置
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityProperties securityProperties;


	@Autowired
	private IgnoringLoginScanner ignoringLoginScanner;

	@Autowired(required = false)
	private HttpSecurityConfigHandler httpSecurityConfigHandler;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		Set<String> ignoringLoginUrl = ignoringLoginScanner.getIgnoringLoginUrl();
		if (CollectionUtil.isNotEmpty(securityProperties.getIgnoringLoginUrl())) {
			ignoringLoginUrl.addAll(securityProperties.getIgnoringLoginUrl());
		}
		List<String> antMatchers = new LinkedList<>();
		for (String s : ignoringLoginScanner.getIgnoringLoginUrl()) {
			antMatchers.add(s);
		}
		http.authorizeRequests().antMatchers(antMatchers.toArray(new String[antMatchers.size()])).permitAll();
		if (null != httpSecurityConfigHandler) {
			httpSecurityConfigHandler.configure(http);
		}
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		if (null != httpSecurityConfigHandler) {
			httpSecurityConfigHandler.configure(web);
		}
	}
}
