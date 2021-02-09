package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.archetype.system.entity.SysRoleMenuDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色和菜单关联表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapperPlus<SysRoleMenuDo> {

}
