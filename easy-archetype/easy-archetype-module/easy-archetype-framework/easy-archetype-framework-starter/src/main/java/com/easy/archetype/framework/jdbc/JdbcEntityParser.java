package com.easy.archetype.framework.jdbc;

import com.easy.archetype.framework.jdbc.annotation.FieldStrategy;

import java.util.List;
import java.util.Map;

/**
 * jdbc工具类
 *
 * @author luyanan
 * @since 2021/3/9
 **/
public interface JdbcEntityParser<T> {


	/**
	 * 根据策略获取字段和值
	 *
	 * @param entity        实体
	 * @param fieldStrategy 策略
	 * @return java.util.Map<java.lang.String, java.lang.Object>
	 * @since 2021/3/9
	 */
	Map<String, Object> getFieldByStrategy(List<EntityFieldInfo> entity, FieldStrategy fieldStrategy, boolean ignoreId);


	/**
	 * 获取实体详情
	 *
	 * @param entity
	 * @return com.easy.archetype.framework.core.jdbc.EntityInfo
	 * @since 2021/3/10
	 */
	EntityInfo<T> getEntityInfo(T entity);
}
