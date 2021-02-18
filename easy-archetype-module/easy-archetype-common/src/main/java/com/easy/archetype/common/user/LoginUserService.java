package com.easy.archetype.common.user;

/**
 * 获取当前用户的service
 *
 * @author luyanan
 * @since 2021/1/31
 **/

public interface LoginUserService {

	/**
	 * 获取用户id
	 * @return java.lang.Long
	 * @since 2021/1/31
	 */
	Long getUserId();

	/**
	 * 获取当前用户
	 * @return com.easy.archetype.common.user.CurrUserVo
	 * @since 2021/1/31
	 */
	LoginUserVo getUser();

}
