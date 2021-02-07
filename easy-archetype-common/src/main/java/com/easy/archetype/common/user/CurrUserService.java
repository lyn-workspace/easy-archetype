package com.easy.archetype.common.user;

/**
 * 获取当前用户的service
 *
 * @author luyanan
 * @since 2021/1/31
 **/

public interface CurrUserService {

    /**
     * 获取用户id
     *
     * @return java.lang.Long
     * @since 2021/1/31
     */
    Long userId();


    /**
     * 获取当前用户
     *
     * @return com.easy.archetype.common.user.CurrUserVo
     * @since 2021/1/31
     */
    CurrUserVo user();
}
