package com.easy.archetype.framework.generate.core;

/**
 * 注册类
 *
 * @author luyanan
 * @since 2021/1/31
 **/
@FunctionalInterface
public interface FactoryRegistryHandler<T> {

    /**
     * 注册
     *
     * @param entity
     * @return void
     * @since 2021/1/31
     */
    void registry(T entity);

}
