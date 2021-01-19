package com.easy.archetype.system.mapper;

import com.easy.archetype.system.entity.SysRoleDeptDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色和部门关联表 Mapper 接口
 * </p>
 *
 * @author luyanan
 * @since 2021-01-19
 */
@Mapper
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDeptDO> {

}
