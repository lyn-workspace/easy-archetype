package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.entity.SysUserPostDO;
import com.easy.archetype.system.mapper.SysUserPostMapper;
import com.easy.archetype.system.service.ISysUserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author luyanan
 * @since 2021-01-19
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPostDO> implements ISysUserPostService {

}
