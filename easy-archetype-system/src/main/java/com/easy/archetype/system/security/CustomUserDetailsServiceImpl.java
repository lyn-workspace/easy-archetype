package com.easy.archetype.system.security;

import com.alibaba.fastjson.JSON;
import com.easy.archetype.common.user.CurrUserVo;
import com.easy.archetype.system.entity.SysUserDo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户信息获取
 *
 * @author luyanan
 * @since 2021/1/30
 **/
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private PasswordEncoder passwordEncoder;

	public CustomUserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 查询用户信息
		SysUserDo sysUserDO = null;
		// if (null == sysUserDO) {
		// throw new UsernameNotFoundException(IMsgCode.USER_PASSWORD_NOT_FOUND);
		// }
		// 用户权限
		List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

		return CurrUser.builder().authorities(authorityList)
				.username(JSON.toJSONString(
						CurrUserVo.builder().loginName(username).userId(1L).status(1).userName("admin").build()))
				.password(passwordEncoder.encode("12345")).enabled(true).build();
	}

}
