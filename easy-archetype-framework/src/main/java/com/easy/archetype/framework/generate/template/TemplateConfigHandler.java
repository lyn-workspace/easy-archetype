package com.easy.archetype.framework.generate.template;

import com.easy.archetype.framework.generate.config.TemplateConfig;

/**
 * 模板配置处理类
 *
 * @author luyanan
 * @since 2021/2/2
 **/
@FunctionalInterface
public interface TemplateConfigHandler {

	/**
	 * 模板处理
	 * @param templateConfig 模板配置
	 * @return void
	 * @since 2021/2/2
	 */
	void handler(TemplateConfig templateConfig);

}
