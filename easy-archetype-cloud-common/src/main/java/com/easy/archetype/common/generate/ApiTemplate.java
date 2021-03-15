package com.easy.archetype.common.generate;

import com.easy.archetype.framework.page.PageInfo;
import com.easy.archetype.framework.page.PageRequestParams;
import com.easy.archetype.framework.page.RespEntity;
import com.easy.archetype.generate.config.TemplateConfig;
import com.easy.archetype.generate.core.TableInfoEntity;
import com.easy.archetype.generate.template.AbstractTemplate;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

/**
 * Api接口层模板
 *
 * @author luyanan
 * @since 2021/2/28
 **/
public class ApiTemplate extends AbstractTemplate {

	private TemplateConfig entityVoTemplateConfig;

	private String applicationName;


	public ApiTemplate(TemplateConfig entityVoTemplateConfig,
					   String applicationName) {
		this.entityVoTemplateConfig = entityVoTemplateConfig;
		this.applicationName = applicationName;
	}

	@Override
	public void before(TableInfoEntity tableInfoEntity, TemplateConfig config, Map<String, Object> data) {
		data.put("entityVoConfig", entityVoTemplateConfig);
		data.put("applicationName", applicationName);
		String requestMapping = tableInfoEntity.getTableName().replaceAll("_", "/").toLowerCase();
		data.put("requestMapping", requestMapping);

		setImport(FeignClient.class,
				PageInfo.class,
				PageRequestParams.class,
				RespEntity.class,
				ApiOperation.class,
				Validated.class
		);
		setImport(entityVoTemplateConfig.getFullPkg());

	}

	@Override
	public String templatePath() {
		return GenerateConstants.TEMPLATE_PATH + "api.ftl";
	}

	@Override
	public String fileNameFormat() {
		return "%sApi";
	}

	@Override
	public String pkg() {
		return "api.api";
	}
}
