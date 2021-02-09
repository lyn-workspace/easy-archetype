package com.easy.archetype.common.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class CurrUserVo {

	/**
	 * 用户id
	 *
	 * @since 2021/1/31
	 */
	private Long userId;

	/**
	 * 用户昵称
	 *
	 * @since 2021/1/31
	 */
	private String userName;

	/**
	 * 登录名
	 *
	 * @since 2021/1/31
	 */
	private String loginName;

	/**
	 * 状态
	 *
	 * @since 2021/1/31
	 */
	private Integer status;

}
