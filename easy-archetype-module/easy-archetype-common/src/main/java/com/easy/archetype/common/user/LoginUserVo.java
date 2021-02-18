package com.easy.archetype.common.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 当前用户Vo类
 *
 * @author luyanan
 * @since 2021/1/31
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {

	/**
	 * 用户id
	 *
	 * @since 2021/1/31
	 */
	private Long userId;

	/**
	 * 用户账号
	 */
	@ApiModelProperty(value = "用户账号")
	private String userName;

	/**
	 * 用户昵称
	 */
	@ApiModelProperty(value = "用户昵称")
	private String nickName;

	/**
	 * 用户类型（00系统用户）
	 */
	@ApiModelProperty(value = "用户类型（00系统用户）")
	private String userType;


	/**
	 * 权限列表
	 *
	 * @since 2021/2/12
	 */
	@ApiModelProperty(value = "权限列表")
	private Set<String> permissions;


	/**
	 * 角色id列表
	 *
	 * @since 2021/2/12
	 */
	@ApiModelProperty(value = "角色id列表")
	private Set<Long> roleIds;
}
