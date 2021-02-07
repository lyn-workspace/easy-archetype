package com.easy.archetype.system.controller;

import com.easy.archetype.common.user.CurrUserService;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.system.service.ISysMenuService;
import com.easy.archetype.system.vo.RouterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单控制层
 *
 * @author luyanan
 * @since 2021/2/7
 **/
@Api(tags = "菜单")
@RestController
@RequestMapping("system/menu")
public class SysMenuController {
    @Autowired
    private CurrUserService currUserService;

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 获取路由信息
     *
     * @return com.easy.archetype.framework.core.RespEntity
     * @since 2021/2/7
     */
    @ApiOperation(value = "获取路由信息", response = RouterVo.class)
    @GetMapping("getRouters")
    public RespEntity getRouters() {

        List<RouterVo> routers = sysMenuService.getRouters(currUserService.userId());
        return RespEntity.success(routers);
    }

}
