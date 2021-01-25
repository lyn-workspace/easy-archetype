package com.easy.archetype.ui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆的controller
 *
 * @author luyanan
 * @since 2021/1/24
 **/
@Controller
@Api(value = "登陆")
public class LoginController {

    @Value("${name}")
    private String name;

    /**
     * 跳转到登陆页面
     *
     * @return java.lang.String
     * @since 2021/1/24
     */
    @ApiOperation(value = "跳转到login页面")
    @GetMapping("login")
    public String login() {
        System.out.println(name);
        return "login";
    }

}
