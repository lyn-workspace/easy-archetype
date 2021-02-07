package com.easy.archetype.ui.controller;

import com.easy.archetype.common.user.CurrUserService;
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
    private CurrUserService currUserService;

    @ApiOperation(value = "跳转首页")
    @GetMapping("index")
    public String index() {
        Long userId = currUserService.userId();

        return "index";
    }

}
