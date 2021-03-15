package com.easy.archetype.system.manage.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.easy.archetype.system.mapper.SysUserRoleMapper;
import com.easy.archetype.data.manage.impl.ManageImpl;
import com.easy.archetype.system.entity.SysUserRoleDo;
import com.easy.archetype.system.manage.ISysUserRoleManage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户和角色关联表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysUserRoleManageImpl extends ManageImpl<SysUserRoleMapper, SysUserRoleDo> implements ISysUserRoleManage {

	@Override
	public void deleteByRoleIds(List<Long> roleIds) {
		if (CollectionUtil.isEmpty(roleIds)) {
			return;
		}
		this.remove(lambdaQueryWrapper(null).in(SysUserRoleDo::getRoleId, roleIds));
	}
}
