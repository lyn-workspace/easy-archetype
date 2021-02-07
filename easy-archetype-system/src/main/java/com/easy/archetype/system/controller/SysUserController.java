package com.easy.archetype.system.controller;

import com.easy.archetype.common.user.CurrUserService;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.entity.SysRoleDo;
import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.service.ISysMenuService;
import com.easy.archetype.system.service.ISysRoleService;
import com.easy.archetype.system.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户信息
 *
 * @author luyanan
 * @since 2021/2/3
 **/
@RestController
@RequestMapping("/system/user")
public class SysUserController {

    @Autowired
    private CurrUserService currUserService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 获取用户信息
     *
     * @return com.easy.archetype.framework.core.RespEntity
     * @since 2021/2/3
     */
    @ApiOperation(value = "获取用户信息")
    @GetMapping("getInfo")
    public RespEntity getInfo() {
        Long userId = currUserService.userId();

        // 获取用户信息
        SysUserDo sysUserDo = sysUserService.findById(userId);

        // 角色集合
        List<SysRoleDo> sysRoleDos = sysRoleService.listByUserId(userId);
        Set<String> roles = new HashSet<>();
        for (SysRoleDo sysRoleDo : sysRoleDos) {
            roles.addAll(Arrays.asList(sysRoleDo.getRoleKey().split(",")));
        }
        // 菜单集合
        List<SysMenuDo> sysMenuDos = sysMenuService.listByRoleIds(sysRoleDos.stream().map(a -> a.getRoleId()).distinct().collect(Collectors.toList()));

        Map<String, Object> map = new HashMap<>(3);
        map.put("user", sysUserDo);
        map.put("roles", roles);
        Set<String> permissions = new HashSet<>();
        sysMenuDos.stream().forEach(sysMenuDo -> {
            permissions.addAll(Arrays.asList(sysMenuDo.getPerms().split(",")));
        });
        map.put("permissions", permissions);
        return RespEntity.success(map);
    }

}
