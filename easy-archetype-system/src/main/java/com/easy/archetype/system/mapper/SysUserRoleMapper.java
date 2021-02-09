package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.easy.archetype.system.entity.SysUserRoleDo;

/**
 * <p>
 * 用户和角色关联表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapperPlus<SysUserRoleDo> {

}
