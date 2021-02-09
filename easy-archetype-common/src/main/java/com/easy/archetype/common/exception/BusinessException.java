package com.easy.archetype.common.exception;

import com.easy.archetype.framework.spring.message.MessageUtils;

/**
 * <p>
 * 自定义异常
 * </p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	/**
	 * 异常码
	 *
	 * @since 2021/2/9
	 */
	private final String code;

	public BusinessException(String code) {
		this.code = code;
	}

	public BusinessException(String code, Throwable e) {
		super(code, e);
		this.code = code;
	}

	@Override
	public String getMessage() {
		return this.code + ":" + MessageUtils.getMessage(code);
	}

	public String getCode() {
		return code;
	}

}
