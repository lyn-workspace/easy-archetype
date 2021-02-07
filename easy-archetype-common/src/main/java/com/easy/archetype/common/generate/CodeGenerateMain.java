package com.easy.archetype.common.generate;

import com.easy.archetype.framework.generate.GenerateBootstrap;
import com.easy.archetype.framework.generate.ext.simple.SimpleTemplateGroup;

/**
 * 代码生成main方法
 *
 * @author luyanan
 * @since 2021/2/2
 **/
public class CodeGenerateMain {
    public static void main(String[] args) {
        new GenerateBootstrap()
                .configHandler(a -> {
                    a.setModule("system");
                })
                .templateGroupRegister(a -> {
                    a.put(EasyEarchetypeVueTemplateGroup.class, new EasyEarchetypeVueTemplateGroup(true, true));
                })
                .generate(EasyEarchetypeVueTemplateGroup.class);
    }
}
