package com.easy.archetype.system.security;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.easy.archetype.common.user.CurrUserService;
import com.easy.archetype.common.user.CurrUserVo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 当前用户的实现类
 *
 * @author luyanan
 * @since 2021/1/31
 **/

@Service
public class CurrUserServiceImpl implements CurrUserService {

	@Override
	public Long userId() {
		return user().getUserId();
	}

	@Override
	public CurrUserVo user() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (null == principal) {
			return null;
		}
		return JSON.parseObject(principal.toString(), CurrUserVo.class);
	}

}
