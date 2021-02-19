package com.easy.archetype.system.controller;

import cn.hutool.core.codec.Base64;
import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.framework.logger.annotation.IgnoreLogger;
import com.easy.archetype.security.annotation.IgnoringLogin;
import com.easy.archetype.security.validatecode.ValidateCodeTemplate;
import com.easy.archetype.system.config.SystemProperties;
import com.easy.archetype.system.enums.SystemRedisKeyEnums;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 验证码控制层
 *
 * @author luyanan
 * @since 2021/2/4
 **/
@Api(tags = "验证码")
@IgnoringLogin
@RestController
public class CaptchaController {


	@Autowired
	private ValidateCodeTemplate validateCodeTemplate;

	@ApiOperation(value = "生成验证码")
	@IgnoreLogger(type = IgnoreLogger.IgnoreLoggerType.RESULT)
	@GetMapping("captchaImage")
	public RespEntity getCode() {
		String uuid = UUID.randomUUID().toString();
		// 创建验证码
		Map<String, Object> map =
				validateCodeTemplate.create(uuid, SystemRedisKeyEnums.CAPTCHA_CODES.getExpire());

		return RespEntity.success(map);
	}

}
