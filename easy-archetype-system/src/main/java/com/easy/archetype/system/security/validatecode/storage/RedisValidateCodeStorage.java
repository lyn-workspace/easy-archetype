package com.easy.archetype.system.security.validatecode.storage;

import com.easy.archetype.system.enums.SystemRedisKeyEnums;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

/**
 * 使用redis存储验证码
 *
 * @author luyanan
 * @since 2021/2/10
 **/
public class RedisValidateCodeStorage implements ValidateCodeStorage {

	private RedisTemplate<String, String> redisTemplate;

	public RedisValidateCodeStorage(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void storage(String key, String code, Duration timeout) {
		redisTemplate.opsForValue().set(SystemRedisKeyEnums.CAPTCHA_CODES.getKey(key), code, timeout);
	}

	@Override
	public String getCode(String key) {
		String value = redisTemplate.opsForValue().get(SystemRedisKeyEnums.CAPTCHA_CODES.getKey(key));
		return value;
	}
}
