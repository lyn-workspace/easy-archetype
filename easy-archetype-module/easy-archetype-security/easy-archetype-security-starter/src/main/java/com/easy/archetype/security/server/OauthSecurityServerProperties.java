package com.easy.archetype.security.server;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 服务端的配置
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@ConfigurationProperties(prefix = OauthSecurityServerProperties.PREFIX)
public class OauthSecurityServerProperties {

	public static final String PREFIX = "easy.archetype.security.server";
}
