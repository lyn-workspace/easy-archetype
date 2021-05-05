package com.easy.archetype.system.manage.impl;

import com.easy.archetype.system.manage.ISysJobLogManage;
import com.easy.archetype.system.mapper.SysJobLogMapper;
import com.easy.archetype.system.entity.SysJobLogDo;
import io.github.fallingsoulm.easy.archetype.data.manage.impl.ManageImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysJobLogManageImpl extends ManageImpl<SysJobLogMapper, SysJobLogDo> implements ISysJobLogManage {

}
