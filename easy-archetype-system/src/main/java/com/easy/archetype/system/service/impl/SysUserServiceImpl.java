package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.manage.ISysUserManage;
import com.easy.archetype.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 用户信息表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
@Primary
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private ISysUserManage iSysUserManage;

	@Override
	public SysUserDo findById(Long userId) {
		return Optional.ofNullable(iSysUserManage.findById(userId)).map(a -> {
			// 不返回密码
			a.setPassword(null);
			return a;
		}).get();
	}

}
