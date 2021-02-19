package com.easy.archetype.ui.controller;

import com.easy.archetype.security.core.LoginUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登陆页面
 *
 * @author luyanan
 * @since 2021/1/31
 **/
@Controller
public class IndexController {

	@Autowired(required = false)
	private LoginUserService loginUserService;

	@ApiOperation(value = "跳转首页")
	@GetMapping("index")
	public String index() {
		Long userId = loginUserService.getUserId();

		return "index";
	}

}
