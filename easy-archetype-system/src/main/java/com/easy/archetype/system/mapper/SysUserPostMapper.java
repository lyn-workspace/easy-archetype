package com.easy.archetype.system.mapper;

import com.easy.archetype.system.entity.SysUserPostDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与岗位关联表 Mapper 接口
 * </p>
 *
 * @author luyanan
 * @since 2021-01-19
 */
@Mapper
public interface SysUserPostMapper extends BaseMapper<SysUserPostDO> {

}
