package com.easy.archetype.common.generate;

import com.easy.archetype.framework.generate.config.TemplateConfig;
import com.easy.archetype.framework.generate.core.TableInfoEntity;
import com.easy.archetype.framework.generate.template.AbstractTemplate;
import com.easy.archetype.framework.manage.IManage;

import java.util.Map;

/**
 * manage模板
 *
 * @author luyanan
 * @since 2021/2/3
 **/
public class ManageTemplate extends com.easy.archetype.framework.generate.ext.simple.ManageTemplate {

	/**
	 * 实体类模板配置
	 *
	 * @since 2021/2/3
	 */
	private TemplateConfig entityConfig;

	public ManageTemplate(TemplateConfig entityConfig) {
		this.entityConfig = entityConfig;
	}

	@Override
	public void before(TableInfoEntity tableInfoEntity, TemplateConfig config, Map<String, Object> data) {
		data.put("entityConfig", entityConfig);
		setImport(entityConfig.getFullPkg());
		setImport(IManage.class);
	}

	@Override
	public String templatePath() {
		return GenerateConstants.TEMPLATE_PATH + "manage.ftl";
	}

}
