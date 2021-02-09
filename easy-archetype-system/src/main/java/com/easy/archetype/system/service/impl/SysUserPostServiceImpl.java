package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.manage.ISysUserPostManage;
import com.easy.archetype.system.service.ISysUserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysUserPostServiceImpl implements ISysUserPostService {

	@Autowired
	private ISysUserPostManage iSysUserPostManage;

}
