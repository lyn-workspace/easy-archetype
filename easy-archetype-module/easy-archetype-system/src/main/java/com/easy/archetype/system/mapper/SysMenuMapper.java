package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.archetype.system.entity.SysMenuDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单权限表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Mapper
public interface SysMenuMapper extends BaseMapperPlus<SysMenuDo> {

}
