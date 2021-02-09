package com.easy.archetype.system.security.validatecode;

/**
 * 验证码的存储
 *
 * @author luyanan
 * @since 2021/2/9
 **/
public interface ValidateCodeStorage {


	/**
	 * 存储验证码
	 *
	 * @param key  验证码的key
	 * @param code 验证码
	 * @return void
	 * @since 2021/2/9
	 */
	void storage(String key, String code);


	/**
	 * 获取验证码
	 *
	 * @param key 验证码的key
	 * @return java.lang.String
	 * @since 2021/2/9
	 */
	String getCode(String key);
}
