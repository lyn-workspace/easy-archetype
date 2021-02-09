package com.easy.archetype.system.service;

import com.easy.archetype.system.entity.SysUserRoleDo;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysUserRoleService {

	/**
	 * 根据条件查询
	 * @param sysUserRoleDo
	 * @return java.util.List<com.easy.archetype.system.entity.SysUserRoleDo>
	 * @since 2021/2/4
	 */
	List<SysUserRoleDo> list(SysUserRoleDo sysUserRoleDo);

}
