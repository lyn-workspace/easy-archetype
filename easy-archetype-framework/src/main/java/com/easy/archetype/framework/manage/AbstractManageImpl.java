package com.easy.archetype.framework.manage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.archetype.framework.core.PageInfo;
import com.easy.archetype.framework.core.PageRequestParams;
import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * manage的抽象类
 *
 * @author luyanan
 * @since 2021/1/20
 **/
public abstract class AbstractManageImpl<M extends BaseMapperPlus<T>, T> extends ServiceImpl<M, T> implements IManage<T> {


    @Autowired
    protected M baseMapper;


    /**
     * Lambda 查询条件构造器
     *
     * @param entity 实体条件
     * @return com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<T>
     * @since 2021/1/20
     */
    protected LambdaQueryWrapper<T> lambdaQueryWrapper(T entity) {
        return queryWrapper(entity).lambda();
    }


    /**
     * 查询条件构造器
     *
     * @param entity 实体条件
     * @return com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
     * @since 2021/1/20
     */
    protected QueryWrapper<T> queryWrapper(T entity) {
        QueryWrapper queryWrapper = new QueryWrapper();
        return queryWrapper;
    }

    /**
     * 修改条件构造器
     *
     * @param entity 实体条件
     * @return com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper<T>
     * @since 2021/1/20
     */
    protected UpdateWrapper<T> updateWrapper(T entity) {
        return new UpdateWrapper<>(entity);
    }

    /**
     * 修改条件构造器
     *
     * @param entity 实体条件
     * @return com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper<T>
     * @since 2021/1/20
     */
    protected LambdaUpdateWrapper<T> lambdaUpdateWrapper(T entity) {
        return updateWrapper(entity).lambda();
    }


    @Override
    public boolean updateById(T entity) {
        return false;
    }
}
