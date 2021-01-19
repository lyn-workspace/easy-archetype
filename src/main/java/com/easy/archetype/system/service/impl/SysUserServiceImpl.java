package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.entity.SysUserDO;
import com.easy.archetype.system.mapper.SysUserMapper;
import com.easy.archetype.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author luyanan
 * @since 2021-01-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO> implements ISysUserService {

}
