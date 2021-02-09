package com.easy.archetype.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.easy.archetype.system.entity.SysMenuDo;
import com.easy.archetype.system.entity.SysRoleDo;
import com.easy.archetype.system.entity.SysRoleMenuDo;
import com.easy.archetype.system.enums.SysMenuEnums;
import com.easy.archetype.system.manage.ISysMenuManage;
import com.easy.archetype.system.service.ISysMenuService;
import com.easy.archetype.system.service.ISysRoleMenuService;
import com.easy.archetype.system.service.ISysRoleService;
import com.easy.archetype.system.vo.MetaVo;
import com.easy.archetype.system.vo.RouterVo;
import com.easy.archetype.system.vo.SysMenuVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

	@Autowired
	private ISysRoleMenuService sysRoleMenuService;

	@Autowired
	private ISysMenuManage sysMenuManage;

	@Autowired
	private ISysRoleService sysRoleService;

	@Override
	public List<SysMenuDo> listByRoleIds(List<Long> roleIds) {
		if (CollectionUtil.isEmpty(roleIds)) {
			return new ArrayList<>();
		}
		// 查询关联的菜单id
		List<SysRoleMenuDo> sysRoleMenuDos = sysRoleMenuService.findRoleIds(roleIds);
		// 根据菜单id查询菜单
		return sysMenuManage.findByIds(
				sysRoleMenuDos.stream().map(SysRoleMenuDo::getMenuId).distinct().collect(Collectors.toList()),
				Arrays.asList(SysMenuEnums.TYPE_DIR.getCode(), SysMenuEnums.TYPE_DIR.getCode()));
	}

	@Override
	public List<RouterVo> getRouters(Long userId) {
		List<SysMenuDo> sysMenuDos = this.listByUserId(userId);
		List<SysMenuVo> menuVos = sysMenuDos.stream().map(a -> {
			SysMenuVo sysMenuVo = new SysMenuVo();
			BeanUtils.copyProperties(a, sysMenuVo);
			return sysMenuVo;
		}).collect(Collectors.toList());
		List<SysMenuVo> childPerms = getChildPerms(menuVos, 0);
		return buildMenus(childPerms);
	}

	public List<RouterVo> buildMenus(List<SysMenuVo> menus) {
		List<RouterVo> routers = new LinkedList<RouterVo>();
		for (SysMenuVo menu : menus) {
			RouterVo router = new RouterVo();
			router.setHidden("1".equals(menu.getVisible()));
			router.setName(getRouteName(menu));
			router.setPath(getRouterPath(menu));
			router.setComponent(getComponent(menu));
			router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache())));
			List<SysMenuVo> cMenus = menu.getChildren();
			if (!cMenus.isEmpty() && cMenus.size() > 0 && SysMenuEnums.TYPE_DIR.getCode().equals(menu.getMenuType())) {
				router.setAlwaysShow(true);
				router.setRedirect("noRedirect");
				router.setChildren(buildMenus(cMenus));
			}
			else if (isMeunFrame(menu)) {
				List<RouterVo> childrenList = new ArrayList<RouterVo>();
				RouterVo children = new RouterVo();
				children.setPath(menu.getPath());
				children.setComponent(menu.getComponent());
				children.setName(StringUtils.capitalize(menu.getPath()));
				children.setMeta(
						new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache())));
				childrenList.add(children);
				router.setChildren(childrenList);
			}
			routers.add(router);
		}
		return routers;
	}

	/**
	 * 根据父节点的ID获取所有的子节点
	 * @param list 分类表
	 * @param parentId 传入的父节点ID
	 * @return java.util.List<com.easy.archetype.system.vo.SysMenuVo>
	 * @since 2021/2/7
	 */
	public List<SysMenuVo> getChildPerms(List<SysMenuVo> list, int parentId) {
		List<SysMenuVo> returnList = new ArrayList<SysMenuVo>();
		for (Iterator<SysMenuVo> iterator = list.iterator(); iterator.hasNext();) {
			SysMenuVo t = (SysMenuVo) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (t.getParentId() == parentId) {
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}

	/**
	 * 递归列表
	 * @param list
	 * @param t
	 * @return void
	 * @since 2021/2/7
	 */
	private void recursionFn(List<SysMenuVo> list, SysMenuVo t) {
		// 得到子节点列表
		List<SysMenuVo> childList = getChildList(list, t);
		t.setChildren(childList);
		for (SysMenuVo tChild : childList) {
			if (hasChild(list, tChild)) {
				recursionFn(list, tChild);
			}
		}
	}

	/**
	 * 判断是否存在子节点
	 * @param list
	 * @param t
	 * @return boolean
	 * @since 2021/2/7
	 */
	private boolean hasChild(List<SysMenuVo> list, SysMenuVo t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}

	/**
	 * 得到子节点列表
	 * @param list
	 * @param t
	 * @return java.util.List<com.easy.archetype.system.vo.SysMenuVo>
	 * @since 2021/2/7
	 */
	private List<SysMenuVo> getChildList(List<SysMenuVo> list, SysMenuVo t) {
		List<SysMenuVo> tlist = new ArrayList<SysMenuVo>();
		Iterator<SysMenuVo> it = list.iterator();
		while (it.hasNext()) {
			SysMenuVo n = (SysMenuVo) it.next();
			if (n.getParentId().longValue() == t.getMenuId().longValue()) {
				tlist.add(n);
			}
		}
		return tlist;
	}

	@Override
	public List<SysMenuDo> listByUserId(Long userId) {
		// 1. 查询角色

		List<SysRoleDo> sysRoleDos = sysRoleService.listByUserId(userId);
		if (CollectionUtil.isEmpty(sysRoleDos)) {
			return new ArrayList<>();
		}
		// 2. 根据角色id查询菜单列表
		return this.listByRoleIds(sysRoleDos.stream().map(a -> a.getRoleId()).distinct().collect(Collectors.toList()));
	}

	/**
	 * 获取路由名称
	 * @param menu 菜单信息
	 * @return java.lang.String 路由名称
	 * @since 2021/2/7
	 */
	public String getRouteName(SysMenuVo menu) {
		String routerName = StringUtils.capitalize(menu.getPath());
		// 非外链并且是一级目录（类型为目录）
		if (isMeunFrame(menu)) {
			routerName = StringUtils.EMPTY;
		}
		return routerName;
	}

	/**
	 * 获取路由地址
	 * @param menu 菜单信息
	 * @return java.lang.String 路由地址
	 * @since 2021/2/7
	 */
	public String getRouterPath(SysMenuVo menu) {
		String routerPath = menu.getPath();
		// 非外链并且是一级目录（类型为目录）
		if (0 == menu.getParentId().intValue() && SysMenuEnums.TYPE_DIR.getCode().equals(menu.getMenuType())
				&& SysMenuEnums.NO_FRAME.getCode().equals(menu.getIsFrame())) {
			routerPath = "/" + menu.getPath();
		}
		// 非外链并且是一级目录（类型为菜单）
		else if (isMeunFrame(menu)) {
			routerPath = "/";
		}
		return routerPath;
	}

	/**
	 * 获取组件信息
	 * @param menu 菜单信息
	 * @return java.lang.String 组件信息
	 * @since 2021/2/7
	 */
	public String getComponent(SysMenuVo menu) {
		String component = SysMenuEnums.LAYOUT.getCode();
		if (StringUtils.isNotEmpty(menu.getComponent()) && !isMeunFrame(menu)) {
			component = menu.getComponent();
		}
		else if (StringUtils.isEmpty(menu.getComponent()) && isParentView(menu)) {
			component = SysMenuEnums.PARENT_VIEW.getCode();
		}
		return component;
	}

	/**
	 * 是否为菜单内部跳转
	 * @param menu 菜单信息
	 * @return boolean 结果
	 * @since 2021/2/7
	 */
	public boolean isMeunFrame(SysMenuVo menu) {
		return menu.getParentId().intValue() == 0 && SysMenuEnums.TYPE_MENU.getCode().equals(menu.getMenuType())
				&& menu.getIsFrame().equals(SysMenuEnums.NO_FRAME.getCodeInt());
	}

	/**
	 * 是否为parent_view组件
	 * @param menu 菜单信息
	 * @return boolean 结果
	 * @since 2021/2/7
	 */
	public boolean isParentView(SysMenuVo menu) {
		return menu.getParentId().intValue() != 0 && SysMenuEnums.TYPE_DIR.getCode().equals(menu.getMenuType());
	}

}
