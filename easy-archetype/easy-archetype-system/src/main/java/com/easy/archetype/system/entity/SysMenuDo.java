package com.easy.archetype.system.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@ApiModel(value = "菜单权限表")
@TableName("sys_menu")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysMenuDo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 菜单ID
	 */
	@ApiModelProperty(value = "菜单ID")
	@TableId(type = IdType.AUTO)
	private Long menuId;

	/**
	 * 菜单名称
	 */
	@TableField(condition = SqlCondition.LIKE)
	@ApiModelProperty(value = "菜单名称")
	private String menuName;

	/**
	 * 父菜单ID
	 */
	@ApiModelProperty(value = "父菜单ID")
	private Long parentId;

	/**
	 * 显示顺序
	 */
	@ApiModelProperty(value = "显示顺序")
	private Integer orderNum;

	/**
	 * 路由地址
	 */
	@ApiModelProperty(value = "路由地址")
	private String path;

	/**
	 * 组件路径
	 */
	@ApiModelProperty(value = "组件路径")
	private String component;

	/**
	 * 是否为外链（0是 1否）
	 */
	@ApiModelProperty(value = "是否为外链（0是 1否）")
	private Integer isFrame;

	/**
	 * 是否缓存（0缓存 1不缓存）
	 */
	@ApiModelProperty(value = "是否缓存（0缓存 1不缓存）")
	private Integer isCache;

	/**
	 * 菜单类型（M目录 C菜单 F按钮）
	 */
	@ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）")
	private String menuType;

	/**
	 * 菜单状态（0显示 1隐藏）
	 */
	@ApiModelProperty(value = "菜单状态（0显示 1隐藏）")
	private String visible;

	/**
	 * 菜单状态（0正常 1停用）
	 */
	@ApiModelProperty(value = "菜单状态（0正常 1停用）")
	private String status;

	/**
	 * 权限标识
	 */
	@ApiModelProperty(value = "权限标识")
	private String perms;

	/**
	 * 菜单图标
	 */
	@ApiModelProperty(value = "菜单图标")
	private String icon;

	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建者")
	private String createBy;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 更新者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(value = "更新者")
	private String updateBy;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

}
