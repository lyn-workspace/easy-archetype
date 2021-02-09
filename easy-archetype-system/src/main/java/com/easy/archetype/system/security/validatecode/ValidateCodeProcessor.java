package com.easy.archetype.system.security.validatecode;

/**
 * 验证码处理逻辑
 *
 * @author luyanan
 * @since 2021/2/9
 **/
public interface ValidateCodeProcessor {


	/**
	 * 验证码创建
	 *
	 * @param key  验证码的key
	 * @param code 验证码
	 * @return void
	 * @since 2021/2/9
	 */
	void create(String key, String code);


	/**
	 * 验证码校验
	 *
	 * @param key  验证码的key
	 * @param code 验证码
	 * @return void
	 * @since 2021/2/9
	 */
	void validate(String key, String code);
}
