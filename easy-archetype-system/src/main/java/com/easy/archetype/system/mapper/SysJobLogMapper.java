package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper ;
import org.apache.ibatis.annotations.Mapper ;
import com.easy.archetype.system.entity.SysJobLogDo ;
/**
 * <p>
 * 定时任务调度日志表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Mapper
public interface SysJobLogMapper extends BaseMapperPlus<SysJobLogDo> {


}
