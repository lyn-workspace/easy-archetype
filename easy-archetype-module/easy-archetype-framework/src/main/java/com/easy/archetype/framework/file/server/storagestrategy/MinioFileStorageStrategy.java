package com.easy.archetype.framework.file.server.storagestrategy;

import com.easy.archetype.framework.file.server.FileServerProperties;
import com.easy.archetype.framework.file.server.IFileStorageStrategy;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;

/**
 * minno文件存储
 *
 * @author luyanan
 * @since 2021/2/23
 **/
@RequiredArgsConstructor
public class MinioFileStorageStrategy implements IFileStorageStrategy {

	private final FileServerProperties fileServerProperties;

	private AmazonS3 amazonS3;


	@Override
	public String upload(String path, String fileName, InputStream is) {
		return null;
	}

	@Override
	public boolean removeFile(String path) {
		return false;
	}
}
