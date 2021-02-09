package com.easy.archetype.system.controller;

import cn.hutool.core.codec.Base64;
import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.framework.logger.annotation.IgnoreLogger;
import com.easy.archetype.system.config.SystemProperties;
import com.easy.archetype.system.enums.SystemRedisKeyEnums;
import com.easy.archetype.system.security.IgnoringLogin;
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

	@Resource(name = "captchaProducer")
	private Producer captchaProducer;

	@Resource(name = "captchaProducerMath")
	private Producer captchaProducerMath;

	@Autowired
	private SystemProperties systemProperties;

	@Autowired
	private RedisTemplate redisTemplate;

	@ApiOperation(value = "生成验证码")
	@IgnoreLogger(type = IgnoreLogger.IgnoreLoggerType.RESULT)
	@GetMapping("captchaImage")
	public RespEntity getCode() {
		String uuid = UUID.randomUUID().toString();
		String redisKey = SystemRedisKeyEnums.CAPTCHA_CODES.getKey(uuid);
		// 生成验证码
		String capStr = null, code = null;
		BufferedImage image = null;

		String captchaType = systemProperties.getCaptchaType();
		if ("math".equals(captchaType)) {
			String capText = captchaProducerMath.createText();
			capStr = capText.substring(0, capText.lastIndexOf("@"));
			code = capText.substring(capText.lastIndexOf("@") + 1);
			image = captchaProducerMath.createImage(capStr);
		}
		else if ("char".equals(captchaType)) {
			capStr = code = captchaProducer.createText();
			image = captchaProducer.createImage(capStr);
		}
		// 保存到redis中
		redisTemplate.opsForValue().set(redisKey, code, SystemRedisKeyEnums.CAPTCHA_CODES.getExpire());

		// 转换流信息写出
		FastByteArrayOutputStream os = new FastByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpg", os);
		}
		catch (IOException e) {
			throw new BusinessException(IMsgCode.CAPTCHA_GENERATE_FAIL);
		}

		return RespEntity.success(map -> {
			map.put("uuid", uuid);
			map.put("img", Base64.encode(os.toByteArray()));
		});
	}

}
