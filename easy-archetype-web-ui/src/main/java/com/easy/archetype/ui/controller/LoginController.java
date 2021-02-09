package com.easy.archetype.ui.controller;

import com.easy.archetype.common.user.CurrUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登陆的controller
 *
 * @author luyanan
 * @since 2021/1/24
 **/
@RefreshScope
@Controller
@Api(value = "登陆")
public class LoginController {

	@Autowired
	private CurrUserService currUserService;

	/**
	 * 跳转到登陆页面
	 * @return java.lang.String
	 * @since 2021/1/24
	 */
	@ApiOperation(value = "跳转到login页面")
	@GetMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * 跳转到未授权页面
	 * @return java.lang.String
	 * @since 2021/1/31
	 */
	@ApiOperation(value = "未授权页面")
	@GetMapping("unauth")
	public String unauth() {
		return "error/unauth";
	}

}
