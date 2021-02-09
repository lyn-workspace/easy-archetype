package com.easy.archetype.system.controller;

import com.easy.archetype.common.user.CurrUserService;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.entity.SysRoleDo;
import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.service.ISysMenuService;
import com.easy.archetype.system.service.ISysRoleService;
import com.easy.archetype.system.service.ISysUserService;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.Api;
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
@Api(tags = "用户模块")
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
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/3
	 */
	@ApiOperation(value = "获取用户信息")
	@GetMapping("getInfo")
	@DynamicResponseParameters(
			properties = { @DynamicParameter(name = "user", value = "用户信息", dataTypeClass = SysUserDo.class),
					@DynamicParameter(name = "roles", value = "角色列表", dataTypeClass = List.class),
					@DynamicParameter(name = "permissions", value = "菜单权限列表", dataTypeClass = List.class) })
	public RespEntity<Map<String, Object>> getInfo() {
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
		List<SysMenuDo> sysMenuDos = sysMenuService
				.listByRoleIds(sysRoleDos.stream().map(a -> a.getRoleId()).distinct().collect(Collectors.toList()));

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
