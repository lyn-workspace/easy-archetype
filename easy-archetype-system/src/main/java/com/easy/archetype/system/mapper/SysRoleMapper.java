package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.easy.archetype.system.entity.SysRoleDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色信息表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Mapper
public interface SysRoleMapper extends BaseMapperPlus<SysRoleDo> {


    /**
     * 根据用户id查询角色
     *
     * @param userId 用户id
     * @return java.util.List<com.easy.archetype.system.entity.SysRoleDo>
     * @since 2021/2/4
     */
    List<SysRoleDo> selectRolePermissionByUserId(@Param("userId") Long userId);
}
