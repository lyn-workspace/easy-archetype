package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.entity.SysUserRoleDo;
import com.easy.archetype.system.manage.ISysUserRoleManage;
import com.easy.archetype.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 用户和角色关联表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {


    @Autowired
    private ISysUserRoleManage sysUserRoleManage;

    @Override
    public List<SysUserRoleDo> list(SysUserRoleDo sysUserRoleDo) {
        return Optional.ofNullable(sysUserRoleManage.list(sysUserRoleDo)).orElse(new ArrayList<>());

    }
}
