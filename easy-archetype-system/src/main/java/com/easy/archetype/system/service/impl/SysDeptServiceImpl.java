package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.manage.ISysDeptManage;
import com.easy.archetype.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService {

	@Autowired
	private ISysDeptManage iSysDeptManage;

}
