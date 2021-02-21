package com.easy.archetype.common.generate;

import com.easy.archetype.framework.generate.config.TemplateConfig;
import com.easy.archetype.framework.generate.core.TableInfoEntity;
import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;

import java.util.Map;

/**
 * Mapper文件模板
 *
 * @author luyanan
 * @since 2021/2/3
 **/
public class MapperTemplate extends com.easy.archetype.framework.generate.ext.simple.MapperTemplate {

	public MapperTemplate(TemplateConfig entityConfig, boolean mybatisPlus) {
		super(entityConfig, mybatisPlus);
	}

	public MapperTemplate(TemplateConfig entityConfig) {
		super(entityConfig);
	}

	@Override
	public void before(TableInfoEntity tableInfoEntity, TemplateConfig config, Map<String, Object> data) {
		super.before(tableInfoEntity, config, data);
		setImport(BaseMapperPlus.class);
	}

	@Override
	public String templatePath() {
		return GenerateConstants.TEMPLATE_PATH + "mapper.ftl";
	}

}
