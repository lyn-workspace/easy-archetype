package com.easy.archetype.system.security.validatecode;

import com.easy.archetype.system.enums.SystemRedisKeyEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 验证码过滤器
 *
 * @author luyanan
 * @since 2021/2/10
 **/
@Slf4j
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {


	/**
	 * 验证码校验失败处理器
	 *
	 * @since 2021/2/10
	 */
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	/**
	 * 验证码模板类
	 *
	 * @since 2021/2/10
	 */
	@Autowired
	private ValidateCodeTemplate validateCodeTemplate;

	private static final String FILTER_URL = "/login";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		if (FILTER_URL.equals(request.getRequestURI())) {
			String uuid = request.getParameter("uuid");
			String code = request.getParameter("code");
			// 验证码校验
			log.debug("开始/login接口的验证码校验,uuid:{},code:{}", uuid, code);
			try {
				validateCodeTemplate.validate(uuid, code);
			} catch (ValidateCodeException e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
}
