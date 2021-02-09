package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.service.ISysDictDataService;
import com.easy.archetype.system.manage.ISysDictDataManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {

	@Autowired
	private ISysDictDataManage iSysDictDataManage;

}
