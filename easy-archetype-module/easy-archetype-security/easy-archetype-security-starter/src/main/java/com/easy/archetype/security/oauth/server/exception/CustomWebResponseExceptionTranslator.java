package com.easy.archetype.security.oauth.server;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * 自定义异常转换器
 *
 * @author luyanan
 * @since 2021/2/19
 **/
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
	@Override
	public ResponseEntity translate(Exception e) throws Exception {
		OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
		return ResponseEntity
				.status(oAuth2Exception.getHttpErrorCode())
				.body(new CustomOauthException(oAuth2Exception.getMessage()));
	}
}
