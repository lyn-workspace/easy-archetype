package com.easy.archetype.system.service;

import com.easy.archetype.system.entity.SysRoleMenuDo;

import java.util.List;

/**
 * <p>
 * 角色和菜单关联表 service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysRoleMenuService {

    /**
     * 根据角色id集合查询关联的菜单
     *
     * @param roleIds 角色id集合
     * @return java.util.List<com.easy.archetype.system.entity.SysRoleMenuDo>
     * @since 2021/2/4
     */
    List<SysRoleMenuDo> findRoleIds(List<Long> roleIds);
}
