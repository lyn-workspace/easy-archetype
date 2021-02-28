package com.easy.archetype.common.generate;

import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import com.easy.archetype.framework.generate.config.TemplateConfig;
import com.easy.archetype.framework.generate.core.TableInfoEntity;
import com.easy.archetype.framework.generate.template.AbstractTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * service层模板
 *
 * @author luyanan
 * @since 2021/2/28
 **/
public class ServiceTemplate extends AbstractTemplate {

	private TemplateConfig entityTemplateConfig;

	public ServiceTemplate(TemplateConfig entityTemplateConfig) {
		this.entityTemplateConfig = entityTemplateConfig;
	}

	@Override
	public void before(TableInfoEntity tableInfoEntity, TemplateConfig config, Map<String, Object> data) {

		data.put("entityConfig", entityTemplateConfig);
		setImport(entityTemplateConfig.getFullPkg());
		setImport(PageInfo.class, PageRequestParams.class, List.class, Collection.class);
	}

	@Override
	public String templatePath() {
		return GenerateConstants.TEMPLATE_PATH + "service.ftl";
	}

	@Override
	public String fileNameFormat() {
		return "I%sService";
	}

	@Override
	public String pkg() {
		return "service";
	}
}
