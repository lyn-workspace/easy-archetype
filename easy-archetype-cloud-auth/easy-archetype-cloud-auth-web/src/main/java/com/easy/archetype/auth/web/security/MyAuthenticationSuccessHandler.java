package com.easy.archetype.auth.web.security;

import com.easy.archetype.framework.core.page.RespEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录成功的处理
 *
 * @author luyanan
 * @since 2021/2/10
 **/
@Slf4j
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		log.debug("{}:用户登录成功", authentication.getName());
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(objectMapper.writeValueAsString(RespEntity.success(HeaderAndCookieHttpSessionIdResolver.base64Encode(request.getSession().getId()))));
		out.flush();
		out.close();
	}
}
