package com.easy.archetype.framework.file.server;

/**
 * 文件名生成策略
 *
 * @author luyanan
 * @since 2021/2/22
 **/
public interface FileNameGenerator {


	/**
	 * 文件名生成
	 *
	 * @param path     文件路径
	 * @param fileName 文件名
	 * @return java.lang.String 文件名
	 * @since 2021/2/22
	 */
	String generate(String path, String fileName);
}
