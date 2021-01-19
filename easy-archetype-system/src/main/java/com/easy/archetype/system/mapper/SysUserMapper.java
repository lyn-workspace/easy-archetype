package com.easy.archetype.system.mapper;

import com.easy.archetype.system.entity.SysUserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author luyanan
 * @since 2021-01-19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDO> {

}
