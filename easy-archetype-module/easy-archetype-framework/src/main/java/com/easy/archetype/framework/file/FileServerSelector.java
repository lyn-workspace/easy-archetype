package com.easy.archetype.framework.file;

import com.easy.archetype.framework.file.annotation.EnableFileServer;
import com.easy.archetype.framework.file.server.FileServiceAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 文件服务配置文件动态导入
 *
 * @author luyanan
 * @since 2021/2/24
 **/
@Slf4j
public class FileServerSelector implements ImportSelector {


	@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {
		Map<String, Object> attrs = annotationMetadata
				.getAnnotationAttributes(EnableFileServer.class.getName());
		EnableFileServer.FileMode fileMode = (EnableFileServer.FileMode) attrs.get("mode");
		if (fileMode.equals(EnableFileServer.FileMode.SERVER)) {
			log.debug("开启文件服务服务端");
			return new String[]{FileServiceAutoConfiguration.class.getName()};
		}
		return new String[0];
	}
}
