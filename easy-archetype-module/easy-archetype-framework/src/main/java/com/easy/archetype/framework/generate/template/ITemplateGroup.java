package com.easy.archetype.framework.generate.template;

import com.easy.archetype.framework.generate.config.GlobalConfig;
import com.easy.archetype.framework.generate.conver.IColumnTypeConver;
import com.easy.archetype.framework.generate.core.TableInfoEntity;
import com.easy.archetype.framework.generate.engine.ITemplateEngine;
import com.easy.archetype.framework.generate.file.OutputFile;
import com.easy.archetype.framework.generate.query.ITableQueryResult;

import java.util.List;

/**
 * 模板组
 *
 * @author luyanan
 * @since 2021/2/1
 **/
public interface ITemplateGroup {

	/**
	 * 模板组
	 * @return java.lang.String
	 * @since 2021/2/1
	 */
	String name();

	/**
	 * 代码生成
	 * @param tableInfoEntities 表信息
	 * @param templateEngine 模板引擎
	 * @param globalConfig 全局配置
	 * @return java.util.List<com.easy.archetype.framework.generate.file.OutputFile>
	 * @since 2021/2/1
	 */
	List<OutputFile> generate(List<TableInfoEntity> tableInfoEntities, ITemplateEngine templateEngine,
			GlobalConfig globalConfig);

	/**
	 * 查询需要生成的表的信息
	 * @param tableQueryResult 查询引擎
	 * @param globalConfig 全局配置
	 * @param columnTypeConver 类型转换器
	 * @return java.util.List<com.easy.archetype.framework.generate.core.TableInfoEntity>
	 * @since 2021/2/1
	 */
	List<TableInfoEntity> getGenerateTableInfo(ITableQueryResult tableQueryResult, GlobalConfig globalConfig,
			IColumnTypeConver columnTypeConver);

}
