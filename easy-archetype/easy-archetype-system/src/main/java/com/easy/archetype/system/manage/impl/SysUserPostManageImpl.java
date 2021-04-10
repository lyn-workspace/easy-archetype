package com.easy.archetype.system.manage.impl;

import com.easy.archetype.data.manage.impl.ManageImpl;
import com.easy.archetype.system.manage.ISysUserPostManage;
import com.easy.archetype.system.mapper.SysUserPostMapper;
import com.easy.archetype.system.entity.SysUserPostDo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysUserPostManageImpl extends ManageImpl<SysUserPostMapper, SysUserPostDo> implements ISysUserPostManage {

}
