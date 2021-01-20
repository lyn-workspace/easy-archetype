package com.easy.archetype.framework.manage.impl;

import com.easy.archetype.framework.core.PageInfo;
import com.easy.archetype.framework.core.PageRequestParams;
import com.easy.archetype.framework.manage.AbstractManageImpl;
import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * manage实现
 *
 * @author luyanan
 * @since 2021/1/20
 **/
public class ManageImpl<M extends BaseMapperPlus<T>, T> extends AbstractManageImpl<M, T> {

    @Override
    public T findById(Serializable id) {
        return null;
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
