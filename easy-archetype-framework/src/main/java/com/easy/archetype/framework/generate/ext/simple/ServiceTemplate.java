package com.easy.archetype.framework.generate.ext.simple;

import com.easy.archetype.framework.generate.template.AbstractTemplate;

/**
 * service模板
 *
 * @author luyanan
 * @since 2021/2/2
 **/
public class ServiceTemplate extends AbstractTemplate {


    @Override
    public String templatePath() {
        return "templates/service.ftl";
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
