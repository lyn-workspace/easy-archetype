package com.easy.archetype.data.file.server;

import com.easy.archetype.data.file.IFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

/**
 * 文件服务端实现
 *
 * @author luyanan
 * @since 2021/2/22
 **/
@Slf4j
@RequiredArgsConstructor
public class FileServiceServerImpl implements IFileService {

	private final IFileStorageStrategy fileStorageStrategy;

	private final FileNameGenerator fileNameGenerator = new SimpleFileNameGenerator();

	@Override
	public String upload(String path, String fileName, InputStream is, boolean rename) {
		log.debug("文件上传,文件路径:{},文件名:{},是否重命名:{}", path, fileName, rename);
		if (rename) {
			//文件名重命名
			fileName = fileNameGenerator.generate(path, fileName);
		}
		return fileStorageStrategy.upload(path, fileName, is);
	}


	@Override
	public boolean removeFile(String path) {
		log.debug("删除文件:{}", path );
		return fileStorageStrategy.removeFile(path);
	}
}
