package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.entity.SysRoleMenuDo;
import com.easy.archetype.system.service.ISysRoleMenuService;
import com.easy.archetype.system.manage.ISysRoleMenuManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 角色和菜单关联表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysRoleMenuServiceImpl implements ISysRoleMenuService {


    @Autowired
    private ISysRoleMenuManage iSysRoleMenuManage;


    @Override
    public List<SysRoleMenuDo> findRoleIds(List<Long> roleIds) {

        List<SysRoleMenuDo> sysRoleMenuDos = iSysRoleMenuManage.findRoleIds(roleIds);

        return Optional.ofNullable(sysRoleMenuDos).orElse(new ArrayList<>());
    }
}
