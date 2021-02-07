package com.easy.archetype.framework.generate.ext.doc;

import com.easy.archetype.framework.generate.template.AbstractTemplate;

/**
 * 文件 模板
 *
 * @author luyanan
 * @since 2021/2/2
 **/
public class DocumentTemplate extends AbstractTemplate {

    @Override
    public String templatePath() {
        return "templates/dataBaseDocument.ftl";
    }

    @Override
    public String fileNameFormat() {
        return "数据库文档";
    }

    @Override
    public String pkg() {
        return "doc";
    }

    @Override
    public String fileNameSuffix() {
        return ".md";
    }
}
