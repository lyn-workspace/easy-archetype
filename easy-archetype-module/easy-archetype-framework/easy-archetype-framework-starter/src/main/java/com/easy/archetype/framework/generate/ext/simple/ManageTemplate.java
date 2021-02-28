package com.easy.archetype.framework.generate.ext.simple;

import com.easy.archetype.framework.generate.template.AbstractTemplate;

/**
 * manage层的模板
 *
 * @author luyanan
 * @since 2021/2/2
 **/
public class ManageTemplate extends AbstractTemplate {

	@Override
	public String templatePath() {
		return "templates/manage.ftl";
	}

	@Override
	public String fileNameFormat() {
		return "I%sManage";
	}

	@Override
	public String pkg() {
		return "manage";
	}

}
