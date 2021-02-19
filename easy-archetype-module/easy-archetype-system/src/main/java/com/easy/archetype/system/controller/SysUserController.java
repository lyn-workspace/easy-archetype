package com.easy.archetype.system.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.archetype.framework.core.PageInfo;
import com.easy.archetype.framework.core.PageRequestParams;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.security.core.LoginUserService;
import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.entity.SysPostDo;
import com.easy.archetype.system.entity.SysRoleDo;
import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.service.ISysMenuService;
import com.easy.archetype.system.service.ISysRoleService;
import com.easy.archetype.system.service.ISysUserService;
import com.easy.archetype.system.service.impl.SysPostServiceImpl;
import com.easy.archetype.system.vo.SysUserVo;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/system/user")
/**
 * 用户模块
 * @author luyan
 * @since 2021/2/12
 */
@Api(tags = "用户模块")
public class SysUserController {

	@Autowired
	private LoginUserService loginUserService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysMenuService sysMenuService;

	@Autowired
	private SysPostServiceImpl sysPostService;

	/**
	 * 获取用户信息
	 *
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/3
	 */
	@ApiOperation(value = "获取用户信息")
	@GetMapping("getInfo")
	@DynamicResponseParameters(
			properties = {@DynamicParameter(name = "user", value = "用户信息", dataTypeClass = SysUserDo.class),
					@DynamicParameter(name = "roles", value = "角色列表", dataTypeClass = List.class),
					@DynamicParameter(name = "permissions", value = "菜单权限列表", dataTypeClass = List.class)})
	public RespEntity<Map<String, Object>> getInfo() {
		Long userId = loginUserService.getUserId();

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
			if (StrUtil.isNotBlank(sysMenuDo.getPerms())) {
				permissions.addAll(Arrays.asList(sysMenuDo.getPerms().split(",")));
			}
		});
		map.put("permissions", permissions);
		return RespEntity.success(map);
	}


	/**
	 * 用户列表
	 *
	 * @param pageRequestParams 分页参数
	 * @return com.easy.archetype.framework.core.RespEntity<com.easy.archetype.framework.core.PageInfo < com.easy.archetype.system.entity.SysUserDo>>
	 * @since 2021/2/12
	 */
	@ApiOperation(value = "用户列表")
	@PreAuthorize("@ss.hasPermi('system:user:list')")
	@PostMapping("list")
	public RespEntity<PageInfo<SysUserDo>> list(@RequestBody PageRequestParams<SysUserDo> pageRequestParams) {
		PageInfo<SysUserDo> pageInfo = sysUserService.findByPage(pageRequestParams);
		return RespEntity.success(pageInfo);
	}

	/**
	 * 根据用户编号获取用户详情
	 *
	 * @param userId 用户id
	 * @return com.easy.archetype.framework.core.RespEntity<com.easy.archetype.system.entity.SysUserDo>
	 * @since 2021/2/12
	 */
	@PreAuthorize("@ss.hasPermi('system:user:query')")
	@GetMapping(value = {"/", "/{userId}"})
	@ApiOperation(value = "根据用户编号获取用户详情", response = SysUserDo.class)
	public RespEntity<SysUserDo> getInfo(@PathVariable(value = "userId", required = false) Long userId) {

		return RespEntity.success(map -> {
			// 查询所有的岗位
			List<SysPostDo> sysPostDos = sysPostService.list(SysPostDo.builder().build());
			map.put("posts", sysPostDos);
			// 查询所有的角色
			List<SysRoleDo> sysRoleDos = sysRoleService.list(SysRoleDo.builder().build());
			map.put("roles", sysRoleDos);
			if (ObjectUtil.isNotNull(userId)) {
				map.put("data", sysUserService.findById(userId));
				map.put("postIds", sysPostService.listByUserId(userId).stream().map(a -> a.getPostId()).distinct().collect(Collectors.toList()));
				map.put("roleIds", sysRoleService.listByUserId(userId).stream().map(a -> a.getRoleId()).distinct().collect(Collectors.toList()));

			}
		});
	}

	/**
	 * 新增用户
	 *
	 * @param sysUserVo 用户对象
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/12
	 */
	@PreAuthorize("@ss.hasPermi('system:user:add')")
	@PostMapping
	@ApiOperation(value = "新增用户")
	public RespEntity add(@Validated @RequestBody SysUserVo sysUserVo) {
		return RespEntity.success(sysUserService.insertUser(sysUserVo));
	}


	/**
	 * 修改用户
	 *
	 * @param user 用户信息
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/12
	 */
	@ApiOperation(value = "修改用户")
	@PreAuthorize("@ss.hasPermi('system:user:edit')")
	@PutMapping
	public RespEntity edit(@Validated @RequestBody SysUserVo user) {
		return RespEntity.success(sysUserService.updateUser(user));
	}

	/**
	 * 删除用户
	 *
	 * @param userIds 用户集合
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/12
	 */
	@ApiOperation(value = "删除用户")
	@PreAuthorize("@ss.hasPermi('system:user:remove')")
	@DeleteMapping("/{userIds}")
	public RespEntity remove(@PathVariable Long[] userIds) {
		sysUserService.deleteByIds(Arrays.asList(userIds));
		return RespEntity.success();
	}


	/**
	 * 重置密码
	 *
	 * @param user 用户信息
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/12
	 */
	@ApiOperation(value = "重置密码")
	@PreAuthorize("@ss.hasPermi('system:user:resetPwd')")
	@PutMapping("/resetPwd")
	public RespEntity resetPwd(@RequestBody SysUserVo user) {
		sysUserService.resetPwd(user);
		return RespEntity.success();
	}


	/**
	 * 修改状态
	 *
	 * @param user 用户信息
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/12
	 */
	@ApiOperation(value = "修改状态")
	@PreAuthorize("@ss.hasPermi('system:user:edit')")
	@PutMapping("/changeStatus")
	public RespEntity changeStatus(@RequestBody SysUserVo user) {

		sysUserService.changeStatus(user);
		return RespEntity.success();
	}
}
