package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.entity.SysRoleDo;
import com.easy.archetype.system.entity.SysUserRoleDo;
import com.easy.archetype.system.manage.ISysRoleManage;
import com.easy.archetype.system.service.ISysRoleService;
import com.easy.archetype.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色信息表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

	@Autowired
	private ISysRoleManage sysRoleManage;

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@Override
	public List<SysRoleDo> listByUserId(Long userId) {
		// 根据用户id查询关联的角色id
		List<SysUserRoleDo> sysUserRoleDos = sysUserRoleService.list(SysUserRoleDo.builder().userId(userId).build());
		return Optional
				.ofNullable(sysRoleManage.findByIds(
						sysUserRoleDos.stream().map(SysUserRoleDo::getRoleId).distinct().collect(Collectors.toList())))
				.orElse(new ArrayList<>());
	}

}
