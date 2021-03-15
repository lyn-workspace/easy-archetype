package com.easy.archetype.common.generate;

import com.easy.archetype.generate.config.TemplateConfig;
import com.easy.archetype.generate.core.TableInfoEntity;
import com.easy.archetype.data.manage.IManage;

import java.util.Map;

/**
 * manage模板
 *
 * @author luyanan
 * @since 2021/2/3
 **/
public class ManageTemplate extends com.easy.archetype.generate.ext.simple.ManageTemplate {

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

	@Override
	public String pkg() {
		return GenerateConstants.WEB  + super.pkg();
	}
}
