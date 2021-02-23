package com.easy.archetype.framework.file.exception;

/**
 * 文件异常
 *
 * @author luyanan
 * @since 2021/2/23
 **/
public class FileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileException(String message) {
		super(message);
	}
}
