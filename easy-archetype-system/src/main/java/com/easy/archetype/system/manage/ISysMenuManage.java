package com.easy.archetype.system.manage;

import com.easy.archetype.framework.manage.IManage;
import com.easy.archetype.system.entity.SysMenuDo;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 菜单权限表 manage
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysMenuManage extends IManage<SysMenuDo> {

	/**
	 * 根据id集合和菜单类型查询
	 * @param menuIds id集合
	 * @param menuType 菜单类型
	 * @return java.util.List<com.easy.archetype.system.entity.SysMenuDo>
	 * @since 2021/2/7
	 */
	List<SysMenuDo> findByIds(Collection<Long> menuIds, List<String> menuType);

}
