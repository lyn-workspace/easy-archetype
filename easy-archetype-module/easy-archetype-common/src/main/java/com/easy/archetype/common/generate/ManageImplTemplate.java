package com.easy.archetype.common.generate;

import com.easy.archetype.framework.generate.config.TemplateConfig;
import com.easy.archetype.framework.generate.core.TableInfoEntity;
import com.easy.archetype.framework.manage.impl.ManageImpl;

import java.util.Map;

/**
 * Manage实现类模板
 *
 * @author luyanan
 * @since 2021/2/3
 **/
public class ManageImplTemplate extends com.easy.archetype.framework.generate.ext.simple.ManageImplTemplate {

	public ManageImplTemplate(boolean mybatisPlus, TemplateConfig entityConfig, TemplateConfig mapperConfig,
			TemplateConfig manageConfig) {
		super(mybatisPlus, entityConfig, mapperConfig, manageConfig);
	}

	@Override
	public void before(TableInfoEntity tableInfoEntity, TemplateConfig config, Map<String, Object> data) {
		super.before(tableInfoEntity, config, data);
		setImport(ManageImpl.class);
	}

	@Override
	public String templatePath() {
		return GenerateConstants.TEMPLATE_PATH + "manageImpl.ftl";
	}

}