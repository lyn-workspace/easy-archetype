package com.easy.archetype.file.core;

import java.io.InputStream;

/**
 * 文件 业务层
 *
 * @author luyanan
 * @since 2021/2/22
 **/
public interface IFileService {


	/**
	 * 文件上传
	 *
	 * @param path     文件的路径
	 * @param is       文件流
	 * @param fileName 文件名
	 * @param rename   是否重命名
	 * @return java.lang.String 文件的相对路径
	 * @since 2021/2/22
	 */
	String upload(String path, String fileName, InputStream is, boolean rename);


	/**
	 * 给文件补全路径
	 *
	 * @param path 文件的相对路径
	 * @return java.lang.String
	 * @since 2021/2/22
	 */
	String addHost(String path);


	/**
	 * 移除文件路径的host
	 *
	 * @param path 文件的全路径
	 * @return java.lang.String
	 * @since 2021/2/22
	 */
	String removeHost(String path);

	/**
	 * 删除文件
	 *
	 * @param path 文件路径
	 * @return boolean
	 * @since 2021/2/22
	 */
	boolean deleteFile(String path);
}
