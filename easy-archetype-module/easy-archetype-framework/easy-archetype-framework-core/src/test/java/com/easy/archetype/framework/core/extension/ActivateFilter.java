package com.easy.archetype.framework.core.extension;

import com.easy.archetype.framework.core.extension.annotation.Activate;

/**
 * 自定义激活扩展点
 *
 * @author luyanan
 * @since 2021/3/7
 **/
@Activate(group = "111")
public class ActivateFilter implements Filter {

	@Override
	public String filter(String content) {
		System.out.println("Activate:" + content);
		return "Activate:" + content;
	}
}
