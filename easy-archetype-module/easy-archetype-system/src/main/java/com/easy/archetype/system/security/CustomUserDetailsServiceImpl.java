package com.easy.archetype.system.security;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.easy.archetype.common.user.LoginUserVo;
import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.entity.SysUserRoleDo;
import com.easy.archetype.system.service.ISysMenuService;
import com.easy.archetype.system.service.ISysUserRoleService;
import com.easy.archetype.system.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 自定义用户信息获取
 *
 * @author luyanan
 * @since 2021/1/30
 **/
@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	private final ISysUserService sysUserService;
	private final ISysMenuService sysMenuService;
	private final ISysUserRoleService sysUserRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 查询用户信息
		SysUserDo sysUserDo = sysUserService.findByUserName(username);
		if (null == sysUserDo) {
			throw new UsernameNotFoundException("用户:" + username + "不存在");
		}

		LoginUser loginUser = new LoginUser();

		loginUser.setPassword(sysUserDo.getPassword());
		Set<String> perms = new HashSet<>();
		List<SysMenuDo> sysMenuDos = sysMenuService.listByUserId(sysUserDo.getUserId());
		if (CollectionUtil.isNotEmpty(sysMenuDos)) {

			sysMenuDos.stream().forEach(a -> {
				if (StrUtil.isNotBlank(a.getPerms())) {
					perms.addAll(Arrays.asList(a.getPerms().split(",").clone()));
				}
			});
			List<SimpleGrantedAuthority> authorityList = perms.stream().map(a -> {
				SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(a);
				return simpleGrantedAuthority;
			}).collect(Collectors.toList());
			loginUser.setAuthorities(authorityList);
		}
		// 查询角色
		Set<Long> roleIds = sysUserRoleService.list(SysUserRoleDo.builder().userId(sysUserDo.getUserId()).build()).stream().map(SysUserRoleDo::getRoleId).distinct().collect(Collectors.toSet());

		loginUser.setUsername(JSON.toJSONString(LoginUserVo
				.builder()
				.userName(sysUserDo.getUserName())
				.nickName(sysUserDo.getNickName())
				.userId(sysUserDo.getUserId())
				.permissions(perms)
				.roleIds(roleIds)
				.userType(sysUserDo.getUserType()).build()));
		loginUser.setEnabled(sysUserDo.getStatus().equals("0"));
		return loginUser;
	}

}
