package com.easy.archetype.system.security;

import cn.hutool.core.collection.CollectionUtil;
import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.framework.spring.message.MessageUtils;
import com.easy.archetype.system.security.validatecode.ValidateCodeFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 安全配置类
 *
 * @author luyanan
 * @since 2021/1/30
 **/
@Slf4j
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	// Secutiry 处理链
//    SecurityContextPersistenceFilter
//    --> UsernamePasswordAuthenticationFilter
//    --> BasicAuthenticationFilter
//    --> ExceptionTranslationFilter
//    --> FilterSecurityInterceptor
	@Autowired
	private IgnoringLoginScanner ignoringLoginScanner;

	/**
	 * 配置密码编码器
	 *
	 * @return org.springframework.security.crypto.password.PasswordEncoder
	 * @since 2021/1/30
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ValidateCodeFilter validateCodeFilter;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private MyAuthenticationFailureHandler authenticationFailureHandler;

	@Override
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsServiceImpl(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		Set<String> ignoringLoginUrl = ignoringLoginScanner.getIgnoringLoginUrl();
		ignoringLoginUrl.add("/captchaImage");
		if (CollectionUtil.isNotEmpty(ignoringLoginUrl)) {
			http.authorizeRequests().antMatchers(ignoringLoginUrl.toArray(new String[ignoringLoginUrl.size()]))
					.permitAll();
		}
		http.formLogin().loginProcessingUrl("/login").loginProcessingUrl("/login").successHandler((request, response, authentication) -> {
			log.debug("{}:用户登录成功", authentication.getName());
			Map<String, Object> map = new HashMap<>(16);
			map.put("code", 200);
			map.put("message", "登录成功");
			map.put("data", HeaderAndCookieHttpSessionIdResolver.base64Encode(request.getSession().getId()));
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(objectMapper.writeValueAsString(map));
			out.flush();
			out.close();
		});

//		// 验证码过滤器
//		http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class).
//				authorizeRequests().antMatchers("/login", "/captchaImage");
//		http.authorizeRequests()
//				.antMatchers("/swagger-ui.html")
//				.anonymous().antMatchers("/swagger-resources/**").anonymous().antMatchers("/webjars/**").anonymous()
//				.antMatchers("/*/api-docs").anonymous().antMatchers("/druid/**").anonymous().antMatchers("/doc.html")
//				.anonymous().antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js").permitAll();
//		http.authenticationProvider(authenticationProvider()).httpBasic()
//				// 未登录时，进行json格式的提示，很喜欢这种写法，不用单独写一个又一个的类
//				.authenticationEntryPoint((request, response, authException) -> {
//					response.setContentType("application/json;charset=utf-8");
//					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//					PrintWriter out = response.getWriter();
//					String code = IMsgCode.HTTP_UNAUTHORIZED;
//					String message = MessageUtils.getMessage(code);
//					out.write(objectMapper.writeValueAsString(RespEntity.error(code, message)));
//					out.flush();
//					out.close();
//
//				}).and().authorizeRequests().anyRequest().authenticated() // 必须授权才能范围
//
//				.and().formLogin() // 使用自带的登录
//				.loginPage("/login").usernameParameter("username").passwordParameter("password")
//				.loginProcessingUrl("/login").permitAll()
//				// 登录失败，返回json
//				.failureHandler(authenticationFailureHandler)
//				// 登录成功，返回json
//				.successHandler((request, response, authentication) -> {
//					log.debug("{}:用户登录成功", authentication.getName());
//					Map<String, Object> map = new HashMap<>(16);
//					map.put("code", 200);
//					map.put("message", "登录成功");
//					map.put("data", HeaderAndCookieHttpSessionIdResolver.base64Encode(request.getSession().getId()));
//					response.setContentType("application/json;charset=utf-8");
//					PrintWriter out = response.getWriter();
//					out.write(objectMapper.writeValueAsString(map));
//					out.flush();
//					out.close();
//				}).and().exceptionHandling()
//				// 没有权限，返回json
//				.accessDeniedHandler((request, response, ex) -> {
//					response.setContentType("application/json;charset=utf-8");
//					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//					PrintWriter out = response.getWriter();
//					Map<String, Object> map = new HashMap<String, Object>(16);
//					map.put("code", 403);
//					map.put("message", "权限不足");
//					out.write(objectMapper.writeValueAsString(map));
//					out.flush();
//					out.close();
//				}).and().logout()
//				// 退出成功，返回json
//				.logoutSuccessHandler((request, response, authentication) -> {
//					Map<String, Object> map = new HashMap<String, Object>(16);
//					map.put("code", 200);
//					map.put("message", "退出成功");
//					map.put("data", authentication);
//					response.setContentType("application/json;charset=utf-8");
//					PrintWriter out = response.getWriter();
//					out.write(objectMapper.writeValueAsString(map));
//					out.flush();
//					out.close();
//				}).permitAll()
//				// 实现记住我的功能RememberMeAuthenticationFilter
//				//参数为: remember-me,@see org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices.parameter
//				.and().rememberMe()
//				.tokenRepository(persistentTokenRepository())
//				// 过期时间
//				.tokenValiditySeconds(3600);

		// 开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
		http.csrf().disable().cors().disable();


	}

	@Override
	public void configure(WebSecurity web) {
		// 对于在header里面增加token等类似情况，放行所有OPTIONS请求。
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		// 对默认的UserDetailsService进行覆盖
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//启动的时候是否创建该表，这个表格是保存用户登录信息的
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
}
