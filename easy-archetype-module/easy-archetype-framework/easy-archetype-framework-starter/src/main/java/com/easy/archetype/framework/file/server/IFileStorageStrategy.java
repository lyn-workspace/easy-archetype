package com.easy.archetype.framework.file.server;

import java.io.InputStream;

/**
 * 文件存储策略
 *
 * @author luyanan
 * @since 2021/2/22
 **/
public interface IFileStorageStrategy {
	/**
	 * 文件上传
	 *
	 * @param path     文件路径
	 * @param fileName 文件名
	 * @param is       文件流
	 * @return java.lang.String 文件的路径(相对路径)
	 * @since 2021/2/22
	 */
	String upload(String path, String fileName, InputStream is);

	/**
	 * 根据文件的相对路径删除文件
	 *
	 * @param path 文件的相对路径
	 * @return boolean
	 * @since 2021/2/22
	 */
	boolean removeFile(String path);
}
