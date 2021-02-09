package com.easy.archetype.framework.manage.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.easy.archetype.framework.core.PageInfo;
import com.easy.archetype.framework.core.PageRequestParams;
import com.easy.archetype.framework.manage.AbstractManageImpl;
import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
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
		return this.getById(id);
	}

	@Override
	public PageInfo<T> listByPage(PageRequestParams<T> pageRequestParams) {
		return toPageInfo(pageRequestParams, queryWrapper(pageRequestParams.getParams()));
	}

	@Override
	public List<T> list(T entity) {
		return this.list(queryWrapper(entity));
	}

	@Override
	public List<T> findByIds(Collection<? extends Serializable> ids) {
		if (CollectionUtil.isEmpty(ids)) {
			return new ArrayList<>();
		}
		return this.listByIds(ids);
	}

	@Override
	public T findOne(T entity) {
		return this.getOne(queryWrapper(entity), false);
	}

	@Override
	public int insert(T entity) {
		Assert.notNull(entity, "entity 不能为空");
		return this.baseMapper.insert(entity);
	}

	@Override
	public boolean insertBatch(Collection<T> entitys) {
		if (CollectionUtil.isEmpty(entitys)) {
			return false;
		}
		return this.saveBatch(entitys);
	}

	@Override
	public boolean update(T entity) {
		return this.updateById(entity);
	}

	@Override
	public boolean update(T entity, T conditions) {
		return this.update(entity, updateWrapper(conditions));
	}

	@Override
	public boolean updateBatch(Collection<T> entitys) {
		return this.updateBatchById(entitys);
	}

	@Override
	public boolean deleteById(Serializable id) {
		return this.removeById(id);
	}

	@Override
	public boolean deleteBatch(Collection<? extends Serializable> ids) {
		return this.removeByIds(ids);
	}

	@Override
	public boolean delete(T entity) {
		return this.remove(updateWrapper(entity));
	}

	@Override
	public Integer count(T entity) {
		return this.count(queryWrapper(entity));
	}

}
