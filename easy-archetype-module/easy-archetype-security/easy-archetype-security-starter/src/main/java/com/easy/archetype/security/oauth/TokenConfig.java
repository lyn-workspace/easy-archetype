package com.easy.archetype.security.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

/**
 * 令牌配置
 *
 * @author luyanan
 * @since 2021/2/19
 **/
@Configuration
public class TokenConfig {


	public TokenStore tokenStore() {
		return new JwkTokenStore()
	}


	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		// 对称密钥,资源服务器使用该密钥进行验证
		converter.setSigningKey(springSecurityProperties.getOauth().getTokenSigningKey());
		return converter;
	}
}
