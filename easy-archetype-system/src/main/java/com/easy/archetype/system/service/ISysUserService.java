package com.easy.archetype.system.service;

import com.easy.archetype.system.entity.SysUserDo;

/**
 * <p>
 * 用户信息表 service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysUserService {

    /**
     * 根据用户id查询
     *
     * @param userId 用户id
     * @return com.easy.archetype.system.entity.SysUserDo
     * @since 2021/2/4
     */
    SysUserDo findById(Long userId);
}
