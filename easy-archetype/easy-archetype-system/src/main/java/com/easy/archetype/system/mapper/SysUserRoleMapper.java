package com.easy.archetype.system.mapper;

import com.easy.archetype.data.mybatisplus.BaseMapperPlus;
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
