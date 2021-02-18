package com.easy.archetype.system.security.validatecode;

import com.easy.archetype.system.security.validatecode.captcha.CaptchaValidateCodeProcessor;
import com.easy.archetype.system.security.validatecode.storage.RedisValidateCodeStorage;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 验证码自动配置类
 *
 * @author luyanan
 * @since 2021/2/10
 **/
@Configuration
public class ValidateCodeAutoConfiguration {


	@Bean
	public ValidateCodeTemplate validateCodeTemplate(ObjectProvider<ValidateCodeProcessor> validateCodeProcessors) {
		return new ValidateCodeTemplate(validateCodeProcessors, ValidateCodeConstant.TYPE_IMA);
	}

	@Bean
	public ValidateCodeProcessor captchaValidateCodeProcessor(RedisValidateCodeStorage redisValidateCodeStorage) {
		return new CaptchaValidateCodeProcessor(redisValidateCodeStorage);
	}

	@Bean
	public RedisValidateCodeStorage redisValidateCodeStorage(RedisTemplate redisTemplate) {
		return new RedisValidateCodeStorage(redisTemplate);
	}


}
