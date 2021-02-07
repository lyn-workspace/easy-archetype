package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import com.easy.archetype.system.entity.SysUserDo;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * 用户信息表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Mapper
public interface SysUserMapper extends BaseMapperPlus<SysUserDo> {


}
