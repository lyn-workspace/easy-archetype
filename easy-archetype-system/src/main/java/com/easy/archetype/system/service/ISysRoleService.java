package com.easy.archetype.system.service;

import com.easy.archetype.system.entity.SysRoleDo;

import java.util.List;

/**
 * <p>
 * 角色信息表 service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysRoleService {

	/**
	 * 根据用户id查询角色列表
	 * @param userId 用户id
	 * @return java.util.List<com.easy.archetype.system.entity.SysRoleDo>
	 * @since 2021/2/4
	 */
	List<SysRoleDo> listByUserId(Long userId);

}
