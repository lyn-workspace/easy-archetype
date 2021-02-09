package com.easy.archetype.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@ApiModel(value = "角色和菜单关联表")
@TableName("sys_role_menu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenuDo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	@ApiModelProperty(value = "角色ID")
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@ApiModelProperty(value = "菜单ID")
	private Long menuId;

}
