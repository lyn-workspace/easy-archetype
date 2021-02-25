package com.easy.archetype.framework.file;

import com.easy.archetype.framework.file.annotation.EnableFileServer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 文件服务配置文件动态导入
 *
 * @author luyanan
 * @since 2021/2/24
 **/
public class FileServerSelector implements ImportSelector<EnableFileServer> {



}
