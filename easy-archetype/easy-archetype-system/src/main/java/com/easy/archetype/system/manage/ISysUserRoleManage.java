package com.easy.archetype.system.manage;

import com.easy.archetype.system.entity.SysUserRoleDo;
import io.github.fallingsoulm.easy.archetype.data.manage.IManage;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 manage
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysUserRoleManage extends IManage<SysUserRoleDo> {
	/**
	 * 根据角色id数组删除
	 *
	 * @param roleIds
	 * @return void
	 * @since 2021/2/15
	 */
	void deleteByRoleIds(List<Long> roleIds);
}
