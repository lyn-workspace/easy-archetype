package com.easy.archetype.system.mapper;

import com.easy.archetype.data.mybatisplus.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;
import com.easy.archetype.system.entity.SysJobLogDo;

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
