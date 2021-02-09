package com.easy.archetype.system.security;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 扫描忽略登陆注解的接口
 *
 * @author luyanan
 * @since 2021/1/30
 **/
@Component
public class IgnoringLoginScanner implements InitializingBean, ServletContextAware {

	private Set<String> ignoringLoginUrl = new HashSet<>();

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Override
	public void afterPropertiesSet() {

	}

	@Override
	public void setServletContext(ServletContext servletContext) {

		Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
		if (CollectionUtil.isNotEmpty(handlerMethods)) {
			for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {

				HandlerMethod method = entry.getValue();
				if (method.hasMethodAnnotation(IgnoringLogin.class)
						|| method.getMethod().getDeclaringClass().isAnnotationPresent(IgnoringLogin.class)) {
					Set<String> patterns = entry.getKey().getPatternsCondition().getPatterns();
					ignoringLoginUrl.addAll(patterns);

				}
			}
		}

	}

	public Set<String> getIgnoringLoginUrl() {
		return ignoringLoginUrl;
	}

}