package com.easy.archetype.system.manage.impl;

import com.easy.archetype.framework.manage.impl.ManageImpl;
import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.manage.ISysUserManage;
import com.easy.archetype.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysUserManageImpl extends ManageImpl<SysUserMapper, SysUserDo> implements ISysUserManage {

}
