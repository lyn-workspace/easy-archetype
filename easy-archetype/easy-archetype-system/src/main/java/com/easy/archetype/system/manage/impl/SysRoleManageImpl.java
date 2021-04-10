package com.easy.archetype.system.manage.impl;

import com.easy.archetype.data.manage.impl.ManageImpl;
import com.easy.archetype.system.mapper.SysRoleMapper;
import com.easy.archetype.system.manage.ISysRoleManage;
import com.easy.archetype.system.entity.SysRoleDo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysRoleManageImpl extends ManageImpl<SysRoleMapper, SysRoleDo> implements ISysRoleManage {

	@Override
	public List<SysRoleDo> selectRolePermissionByUserId(Long userId) {

		return this.baseMapper.selectRolePermissionByUserId(userId);

	}

}
