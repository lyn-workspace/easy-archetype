package com.easy.archetype.framework.manage.impl;

import com.easy.archetype.framework.core.PageInfo;
import com.easy.archetype.framework.core.PageRequestParams;
import com.easy.archetype.framework.manage.AbstractManageImpl;
import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 带缓存的Manage实现
 *
 * @author luyanan
 * @since 2021/1/20
 **/
@CacheConfig
public class CacheManageImpl<M extends BaseMapperPlus<T>, T> extends AbstractManageImpl<M, T> {

    @Cacheable(sync = true)
    @Override
    public T findById(Serializable id) {
        return this.getById(id);
    }

    @Override
    public PageInfo<T> listByPage(PageRequestParams<T> pageRequestParams) {
        return null;
    }

    @Override
    public List<T> list(T entity) {
        return null;
    }

    @Override
    public List<T> findByIds(Collection<? extends Serializable> ids) {
        return null;
    }

    @Override
    public T findOne(T entity) {
        return null;
    }

    @Override
    public Serializable insert(T entity) {
        return null;
    }

    @Override
    public int insertBatch(Collection<T> entitys) {
        return 0;
    }

    @Override
    public boolean update(T entity) {
        return false;
    }

    @Override
    public boolean update(T entity, T conditions) {
        return false;
    }

    @Override
    public boolean updateBatch(Collection<T> entitys) {
        return false;
    }

    @Override
    public boolean deleteById(Serializable id) {
        return false;
    }

    @Override
    public boolean deleteBatch(Collection<? extends Serializable> ids) {
        return false;
    }

    @Override
    public boolean delete(T entity) {
        return false;
    }

    @Override
    public Integer count(T entity) {
        return null;
    }
}
