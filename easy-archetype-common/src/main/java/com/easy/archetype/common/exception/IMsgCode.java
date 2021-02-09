package com.easy.archetype.common.exception;

/**
 * <p>
 * 消息编码的接口类
 * </p>
 *
 * @author luyanan
 * @since 2021/1/17
 **/
public interface IMsgCode {

	/**
	 * 成功
	 *
	 * @since 2021/1/24
	 */
	String SUCCESS = "200";

	/**
	 * 未授权
	 *
	 * @since 2021/2/9
	 */
	String HTTP_UNAUTHORIZED = "401";

	/**
	 * 不支持的请求类型
	 *
	 * @since 2021/1/24
	 */
	String HTTP_NOT_FOUND = "405";

	/**
	 * 服务端错误
	 *
	 * @since 2021/1/24
	 */
	String INTERNAL_SERVER_ERROR = "500";

	/***************** 用户模块编码 ******************/
	/**
	 * 用户名/密码不正确
	 *
	 * @since 2021/1/30
	 */
	String USER_PASSWORD_NOT_FOUND = "U_001";

	/**
	 * 验证码生成错误
	 *
	 * @since 2021/2/4
	 */
	String CAPTCHA_GENERATE_FAIL = "U_002";

}
