package com.easy.archetype.cloud.common.generate;


import com.easy.archetype.generate.GenerateBootstrap;

/**
 * 代码生成main方法
 *
 * @author luyanan
 * @since 2021/2/2
 **/
public class CodeGenerateMain {

	public static void main(String[] args) {
		new GenerateBootstrap().configHandler(a -> {
			a.setModule("archetype");
		}).templateGroupRegister(a -> {
			a.put(EasyEarchetypeVueTemplateGroup.class, new EasyEarchetypeVueTemplateGroup(true, true));
		}).generate(EasyEarchetypeVueTemplateGroup.class);
	}

}
