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
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (null == userDetails) {
			return null;
		}
		String username = userDetails.getUsername();
		if (StrUtil.isBlank(username)) {
			return null;
		}
		return JSON.parseObject(username, CurrUserVo.class);
	}

}
