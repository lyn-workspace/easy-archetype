package com.easy.archetype.common.generate;

import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import com.easy.archetype.framework.core.page.RespEntity;
import com.easy.archetype.framework.generate.config.TemplateConfig;
import com.easy.archetype.framework.generate.core.TableInfoEntity;
import com.easy.archetype.framework.generate.template.AbstractTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Api熔断层模板
 *
 * @author luyanan
 * @since 2021/2/28
 **/
public class ApiFallbackTemplate extends AbstractTemplate {

	private TemplateConfig entityVoConfig;

	private TemplateConfig apiTemplateConfig;

	public ApiFallbackTemplate(TemplateConfig entityVoConfig,
							   TemplateConfig apiTemplateConfig) {
		this.entityVoConfig = entityVoConfig;
		this.apiTemplateConfig = apiTemplateConfig;
	}

	@Override
	public void before(TableInfoEntity tableInfoEntity, TemplateConfig config, Map<String, Object> data) {
		data.put("entityVoConfig", entityVoConfig);
		data.put("apiConfig", apiTemplateConfig);
		setImport(entityVoConfig.getFullPkg()
				, apiTemplateConfig.getFullPkg());
		setImport(BusinessException.class,
				IMsgCode.class,
				PageInfo.class,
				PageRequestParams.class,
				RespEntity.class,
				Component.class);

	}

	@Override
	public String templatePath() {
		return GenerateConstants.TEMPLATE_PATH + "apiFallback.ftl";
	}

	@Override
	public String fileNameFormat() {
		return "%sApiFallback";
	}

	@Override
	public String pkg() {
		return "api.api.fallback";
	}
}
