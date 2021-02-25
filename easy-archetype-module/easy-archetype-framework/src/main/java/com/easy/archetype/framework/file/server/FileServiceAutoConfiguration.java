package com.easy.archetype.framework.file.server;

import com.easy.archetype.framework.file.FileProperties;
import com.easy.archetype.framework.file.FileTemplate;
import com.easy.archetype.framework.file.IFileService;
import com.easy.archetype.framework.file.server.storagestrategy.FtpFileStorageStrategy;
import com.easy.archetype.framework.file.server.storagestrategy.MinioFileStorageStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件服务 自动配置类
 *
 * @author luyanan
 * @since 2021/2/25
 **/
@EnableConfigurationProperties({FileProperties.class, FileServerProperties.class})
@Configuration
public class FileServiceAutoConfiguration {


	@Bean
	public FileTemplate fileTemplate(FileProperties fileProperties, IFileService fileService) {
		return new FileTemplate(fileService, fileProperties);
	}

	/**
	 * 存储服务
	 *
	 * @param fileStorageStrategy
	 * @return com.easy.archetype.framework.file.IFileService
	 * @since 2021/2/25
	 */
	@Bean
	public IFileService fileService(IFileStorageStrategy fileStorageStrategy) {
		return new FileServiceServerImpl(fileStorageStrategy);
	}

	/**
	 * ftp存储
	 *
	 * @param fileServerProperties
	 * @return com.easy.archetype.framework.file.server.IFileStorageStrategy
	 * @since 2021/2/25
	 */
	@Bean
	@ConditionalOnProperty(prefix = FileServerProperties.PREFIX, name = "storeType", havingValue = "ftp", matchIfMissing = false)
	public IFileStorageStrategy ftpFileStorageStrategy(FileServerProperties fileServerProperties) {
		return new FtpFileStorageStrategy(fileServerProperties);
	}

	/**
	 * minio存储
	 *
	 * @param fileServerProperties
	 * @return com.easy.archetype.framework.file.server.IFileStorageStrategy
	 * @since 2021/2/25
	 */
	@Bean
	@ConditionalOnProperty(prefix = FileServerProperties.PREFIX, name = "storeType", havingValue = "ftp", matchIfMissing = false)
	public IFileStorageStrategy minioFileStorageStrategy(FileServerProperties fileServerProperties) {
		return new MinioFileStorageStrategy(fileServerProperties);
	}

}
