package com.example;

import com.easy.archetype.framework.file.annotation.EnableFileServer;
import com.easy.archetype.framework.file.server.FileServerProperties;
import com.easy.archetype.framework.file.server.IFileStorageStrategy;
import com.easy.archetype.framework.file.server.storagestrategy.MinioFileStorageStrategy;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableKnife4j
@EnableSwagger2WebMvc
@EnableFileServer(mode = EnableFileServer.FileMode.SERVER)
@SpringBootApplication
public class EasyArchetypeModuleExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyArchetypeModuleExampleApplication.class, args);
	}

	@Bean
	public IFileStorageStrategy minioFileStorageStrategy(FileServerProperties fileServerProperties) {
		return new MinioFileStorageStrategy(fileServerProperties);
	}
}
