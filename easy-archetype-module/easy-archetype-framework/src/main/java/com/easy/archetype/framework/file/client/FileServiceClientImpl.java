package com.easy.archetype.framework.file.client;

import com.easy.archetype.framework.file.IFileService;

import java.io.InputStream;

/**
 * 文件服务客户端的实现
 *
 * @author luyanan
 * @since 2021/2/22
 **/
public class FileServiceClientImpl implements IFileService {
	@Override
	public String upload(String path, String fileName, InputStream is, boolean rename) {
		return null;
	}



	@Override
	public String removeFile(String path) {
		return null;
	}
}
