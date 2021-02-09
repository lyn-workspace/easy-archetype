package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.service.ISysRoleDeptService;
import com.easy.archetype.system.manage.ISysRoleDeptManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysRoleDeptServiceImpl implements ISysRoleDeptService {

	@Autowired
	private ISysRoleDeptManage iSysRoleDeptManage;

}
