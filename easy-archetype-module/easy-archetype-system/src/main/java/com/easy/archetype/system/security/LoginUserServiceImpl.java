package com.easy.archetype.system.security;

import com.alibaba.fastjson.JSON;
import com.easy.archetype.common.user.LoginUserService;
import com.easy.archetype.common.user.LoginUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 当前用户的实现类
 *
 * @author luyanan
 * @since 2021/1/31
 **/

@Slf4j
@Service
public class LoginUserServiceImpl implements LoginUserService {

	@Override
	public Long getUserId() {
		return null != getUser() ? getUser().getUserId() : null;
	}

	@Override
	public LoginUserVo getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (null == principal) {
			return null;
		}
		try {
			return JSON.parseObject(JSON.parseObject(JSON.toJSONString(principal), LoginUserVo.class).getUserName(), LoginUserVo.class);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取用户信息失败:{}", e);
			return null;
		}
	}

}
