package com.easy.archetype.system.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.archetype.common.user.LoginUserService;
import com.easy.archetype.common.user.LoginUserVo;
import com.easy.archetype.system.entity.SysRoleDo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 自定义权限实现，ss取自SpringSecurity首字母
 *
 * @author luyanan
 * @since 2021/2/12
 **/
@Service("ss")
public class PermissionService {

	/**
	 * 所有权限标识
	 */
	private static final String ALL_PERMISSION = "*:*:*";

	/**
	 * 管理员角色权限标识
	 */
	private static final String SUPER_ADMIN = "admin";

	private static final String ROLE_DELIMETER = ",";

	private static final String PERMISSION_DELIMETER = ",";

	@Autowired
	private LoginUserService loginUserService;


	@Autowired
	private ISysRoleService sysRoleService;

	/**
	 * 验证用户是否具有某权限
	 *
	 * @param permission 权限字符串
	 * @return boolean 用户是否具备某权限
	 * @since 2021/2/12
	 */
	public boolean hasPermi(String permission) {

		if (StrUtil.isBlank(permission)) {
			return false;
		}
		LoginUserVo user = loginUserService.getUser();
		if (null == user || CollectionUtil.isEmpty(user.getPermissions())) {
			return false;
		}
		return hasPermissions(user.getPermissions(), permission);

	}

	/**
	 * 验证用户是否不具备某权限,与hasPermi逻辑相反
	 *
	 * @param permission 权限字符串
	 * @return boolean  用户是否不具备
	 * @since 2021/2/12
	 */
	public boolean lacksPermi(String permission) {

		return hasPermi(permission) != false;
	}

	/**
	 * 验证用户是否具有以下任意一个权限
	 *
	 * @param permissions 以 PERMISSION_NAMES_DELIMETER 为分隔符的权限列表
	 * @return boolean 用户是否具有以下任意一个权限
	 * @since 2021/2/12
	 */
	public boolean hasAnyPermi(String permissions) {

		if (StrUtil.isBlank(permissions)) {
			return false;
		}
		LoginUserVo user = loginUserService.getUser();
		if (null == user || CollectionUtil.isEmpty(user.getPermissions())) {
			return false;
		}

		Set<String> authorities = user.getPermissions();
		for (String permission : permissions.split(PERMISSION_DELIMETER)) {
			if (permission != null && hasPermissions(authorities, permission)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断用户是否具有某个角色
	 *
	 * @param role 角色
	 * @return boolean  用户是否具备某角色
	 * @since 2021/2/12
	 */
	public boolean hasRole(String role) {

		if (StrUtil.isBlank(role)) {
			return false;
		}
		LoginUserVo user = loginUserService.getUser();
		if (null == user || CollectionUtil.isEmpty(user.getRoleIds())) {
			return false;
		}
		List<SysRoleDo> sysRoleDos = sysRoleService.findByIds(user.getRoleIds());

		for (SysRoleDo sysRole : sysRoleDos) {
			String roleKey = sysRole.getRoleKey();
			if (SUPER_ADMIN.equals(roleKey) || roleKey.equals(StringUtils.trim(role))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证用户是否不具备某角色,与isRole逻辑相反
	 *
	 * @param role 角色名称
	 * @return boolean 用户是否不具备
	 * @since 2021/2/12
	 */
	public boolean lacksRole(String role) {
		return hasRole(role) != true;
	}

	/**
	 * 验证用户是否具有以下任意一个角色
	 *
	 * @param roles 以 ROLE_NAMES_DELIMETER 为分隔符的角色列表
	 * @return boolean 用户是否具有以下任意一个角色
	 * @since 2021/2/12
	 */
	public boolean hasAnyRoles(String roles) {

		if (StrUtil.isBlank(roles)) {
			return false;
		}

		LoginUserVo user = loginUserService.getUser();
		if (null == user || CollectionUtil.isEmpty(user.getRoleIds())) {
			return false;
		}

		for (String role : roles.split(ROLE_DELIMETER)) {
			if (hasRole(role)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否包含权限
	 *
	 * @param permissions 权限列表
	 * @param permission  权限字符串
	 * @return boolean 用户是否具备某权限
	 * @since 2021/2/12
	 */
	private boolean hasPermissions(Set<String> permissions, String permission) {
		return permissions.contains(ALL_PERMISSION) || permissions.contains(StringUtils.trim(permission));
	}
}
