package com.easy.archetype.ui.controller;

import cn.hutool.http.useragent.UserAgentUtil;
import com.easy.archetype.framework.page.RespEntity;
import com.easy.archetype.security.core.LoginUserService;
import com.easy.archetype.security.core.LoginUserVo;
import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.entity.SysUserDo;
import com.easy.archetype.system.service.ConfigService;
import com.easy.archetype.system.service.ISysUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ConfigService configService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@ApiOperation(value = "跳转首页")
	@GetMapping("index")

	public String index(ModelMap mmap, HttpServletRequest request) {
		Long userId = loginUserService.getUserId();

		SysUserDo userDo = sysUserService.findById(userId);
		// 获取菜单列表
		List<SysMenuDo> sysMenuDoList = sysUserService.findMeunByUserId(userId);
		mmap.put("menus", sysMenuDoList);
		mmap.put("user", userDo);
		mmap.put("sideTheme", configService.getKey("sys.index.sideTheme"));
		mmap.put("skinName", configService.getKey("sys.index.skinName"));
		mmap.put("ignoreFooter", configService.getKey("sys.index.ignoreFooter"));
		// 菜单导航显示风格
		String menuStyle = configService.getKey("sys.index.menuStyle");
		// 移动端，默认使左侧导航菜单，否则取默认配置
		String indexStyle = UserAgentUtil.parse(request.getHeader("User-Agent")).isMobile() ? "index" : menuStyle;


		// 优先Cookie配置导航菜单
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (StringUtils.isNotEmpty(cookie.getName()) && "nav-style".equalsIgnoreCase(cookie.getName())) {
				indexStyle = cookie.getValue();
				break;
			}
		}
		String webIndex = "topnav".equalsIgnoreCase(indexStyle) ? "index-topnav" : "index";
		return webIndex;
	}

	private static final String LOCK_SCREEN = "lockscreen";

	// 锁定屏幕
	@GetMapping("/lockscreen")
	public String lockscreen(ModelMap mmap, HttpSession session) {
		mmap.put("user", loginUserService.getUser());
		session.setAttribute(LOCK_SCREEN, true);
		return "lock";
	}

	// 解锁屏幕
	@PostMapping("/unlockscreen")
	@ResponseBody
	public RespEntity unlockscreen(String password, HttpSession session) {
		LoginUserVo user = loginUserService.getUser();
		if (null == user) {
			return RespEntity.error("服务器超时，请重新登陆");
		}
		if (passwordEncoder.matches(user.getPassword(), password)) {
			session.removeAttribute(LOCK_SCREEN);
			return RespEntity.success();
		}
		return RespEntity.error("密码不正确，请重新输入。");
	}

}
