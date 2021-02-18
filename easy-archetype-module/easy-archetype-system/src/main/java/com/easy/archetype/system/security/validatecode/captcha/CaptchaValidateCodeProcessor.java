package com.easy.archetype.system.security.validatecode.captcha;

import cn.hutool.core.codec.Base64;
import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.system.SystemMsgCode;
import com.easy.archetype.system.config.SystemProperties;
import com.easy.archetype.system.security.validatecode.*;
import com.easy.archetype.system.security.validatecode.storage.ValidateCodeStorage;
import com.google.code.kaptcha.Producer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 图形验证码处理器
 *
 * @author luyanan
 * @since 2021/2/9
 **/
public class CaptchaValidateCodeProcessor extends AbstractValidateCodeProcessor {

	@Resource(name = "captchaProducer")
	private Producer captchaProducer;

	@Resource(name = "captchaProducerMath")
	private Producer captchaProducerMath;

	@Autowired
	private SystemProperties systemProperties;

	/**
	 * 验证码存储
	 *
	 * @since 2021/2/9
	 */
	private ValidateCodeStorage validateCodeStorage;


	public CaptchaValidateCodeProcessor(ValidateCodeStorage validateCodeStorage) {
		this.validateCodeStorage = validateCodeStorage;
	}

	@Override
	public String type() {
		return ValidateCodeConstant.TYPE_IMA;
	}

	@Override
	public ValidateCodeStorage validateCodeStorage() {
		return this.validateCodeStorage;
	}


	@Override
	protected Map<String, Object> doCreate(String key, String code, Duration timeout) {
		Map<String, Object> map = generateImageCaptcha(key);
		code = map.get("code").toString();
		// 存储
		validateCodeStorage.storage(key, code, timeout);
		return map;
	}

	/**
	 * 生成图片验证码
	 *
	 * @param key 验证码的key
	 * @return java.lang.String 验证码
	 * @since 2021/2/10
	 */
	@SneakyThrows
	protected Map<String, Object> generateImageCaptcha(String key) {
		// 生成验证码
		String capStr = null, code = null;
		BufferedImage image = null;
		String captchaType = systemProperties.getCaptchaType();
		if ("math".equals(captchaType)) {
			String capText = captchaProducerMath.createText();
			capStr = capText.substring(0, capText.lastIndexOf("@"));
			code = capText.substring(capText.lastIndexOf("@") + 1);
			image = captchaProducerMath.createImage(capStr);
		} else if ("char".equals(captchaType)) {
			capStr = code = captchaProducer.createText();
			image = captchaProducer.createImage(capStr);
		}

		// 转换流信息写出
		FastByteArrayOutputStream os = new FastByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpg", os);
		} catch (IOException e) {
			throw new BusinessException(SystemMsgCode.CAPTCHA_GENERATE_FAIL);
		}
		// 将结果写出去

		Map<String, Object> result = new HashMap<>();
		result.put("uuid", key);
		result.put("img", Base64.encode(os.toByteArray()));
		result.put("code", code);
		return result;
	}


}
