package com.easy.archetype.system.manage;

import com.easy.archetype.system.entity.SysRoleDeptDo;
import com.easy.archetype.framework.manage.IManage;

import java.util.List;
import java.io.Serializable;

/**
 * <p>
 * 角色和部门关联表 manage
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysRoleDeptManage extends IManage<SysRoleDeptDo> {
	/**
	 * 根据角色id列表删除
	 *
	 * @param roleIds 角色id列表
	 * @return void
	 * @since 2021/2/15
	 */
	void deleteByRoleIds(List<Long> roleIds);
}
