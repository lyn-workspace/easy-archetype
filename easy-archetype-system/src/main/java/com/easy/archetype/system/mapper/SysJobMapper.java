package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus;
import com.easy.archetype.system.entity.SysJobDo;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * 定时任务调度表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Mapper
public interface SysJobMapper extends BaseMapperPlus<SysJobDo> {


}
