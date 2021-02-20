package com.easy.archetype.security.oauth.client.annotation;

import com.easy.archetype.security.oauth.SpringSecurityOauthProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring security 客户端配置
 *
 * @author luyanan
 * @since 2021/2/19
 **/
@ConfigurationProperties(prefix = SpringSecurityOauthClientProperties.class)
public class SpringSecurityOauthClientProperties {
	public static final String PREFIX = SpringSecurityOauthProperties.PREFIX + ".client";
}
