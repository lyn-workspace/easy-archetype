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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@ApiModel(value = "角色信息表")
@TableName("sys_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleDo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	@ApiModelProperty(value = "角色ID")
	@TableId(type = IdType.AUTO)
	private Long roleId;

	/**
	 * 角色名称
	 */
	@NotBlank(message = "角色名称不能为空")
	@Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
	@ApiModelProperty(value = "角色名称")
	@TableField(condition = SqlCondition.LIKE)
	private String roleName;

	/**
	 * 角色权限字符串
	 */
	@NotBlank(message = "权限字符不能为空")
	@Size(min = 0, max = 100, message = "权限字符长度不能超过100个字符")
	@ApiModelProperty(value = "角色权限字符串")
	@TableField(condition = SqlCondition.LIKE)
	private String roleKey;

	/**
	 * 显示顺序
	 */
	@NotBlank(message = "显示顺序不能为空")
	@ApiModelProperty(value = "显示顺序")
	private String roleSort;

	/**
	 * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
	 */
	@ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
	private String dataScope;

	/**
	 * 菜单树选择项是否关联显示
	 */
	@ApiModelProperty(value = "菜单树选择项是否关联显示")
	private Boolean menuCheckStrictly;

	/**
	 * 部门树选择项是否关联显示
	 */
	@ApiModelProperty(value = "部门树选择项是否关联显示")
	private Boolean deptCheckStrictly;

	/**
	 * 角色状态（0正常 1停用）
	 */
	@ApiModelProperty(value = "角色状态（0正常 1停用）")
	private String status;

	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
	@ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
	private String delFlag;

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
