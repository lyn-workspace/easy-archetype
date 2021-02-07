package com.easy.archetype.system.service;

import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.vo.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单权限表 service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysMenuService {


    /**
     * 根据角色id查询菜单列表
     *
     * @param roleIds 角色id集合
     * @return java.util.List<com.easy.archetype.system.entity.SysMenuDo>
     * @since 2021/2/4
     */
    List<SysMenuDo> listByRoleIds(List<Long> roleIds);

    /**
     * 构建前端路由所需要的菜单
     *
     * @param userId 用户id
     * @return java.util.List<com.easy.archetype.system.vo.RouterVo>
     * @since 2021/2/7
     */
    List<RouterVo> getRouters(Long userId);


    /**
     * 根据用户id查询菜单树信息
     *
     * @param userId 用户id
     * @return java.util.List<com.easy.archetype.system.entity.SysMenuDo>
     * @since 2021/2/7
     */
    List<SysMenuDo> listByUserId(Long userId);
}
