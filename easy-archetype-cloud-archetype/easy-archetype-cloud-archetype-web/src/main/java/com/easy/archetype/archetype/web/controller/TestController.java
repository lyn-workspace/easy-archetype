package com.easy.archetype.archetype.web.controller;

import com.easy.archetype.auth.api.api.SysUserApi;
import com.easy.archetype.auth.api.vo.SysUserVo;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.security.core.LoginUserService;
import com.easy.archetype.security.core.LoginUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试控制层
 *
 * @author luyan
 * @since 2021/2/21
 */
@Api(tags = "测试控制层")
@RestController
@RequestMapping("test")
public class TestController {

	@Autowired
	private LoginUserService loginUserService;

	@Autowired
	private SysUserApi sysUserApi;

	/**
	 * 获取用户信息
	 *
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/2/21
	 */
	@ApiOperation(value = "获取用户信息")
	@GetMapping("user")
	public RespEntity getUser() {
		LoginUserVo user = loginUserService.getUser();
		return RespEntity.success(user);
	}


	/**
	 * 获取用户详情
	 *
	 * @return com.easy.archetype.framework.core.RespEntity<com.easy.archetype.auth.api.vo.SysUserVo>
	 * @since 2021/2/21
	 */
	@ApiOperation(value = "获取用户详情")
	@GetMapping("detail")
	public RespEntity<SysUserVo> userDetail() {
		Long userId = loginUserService.getUserId();
		return sysUserApi.findById(userId);
	}
}
