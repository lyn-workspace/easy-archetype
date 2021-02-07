package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl ;
import com.easy.archetype.system.manage.ISysJobManage ;
import com.easy.archetype.framework.manage.impl.ManageImpl ;
import com.easy.archetype.system.mapper.SysJobMapper ;
import com.easy.archetype.system.entity.SysJobDo ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 定时任务调度表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Service
public class SysJobManageImpl extends ManageImpl<SysJobMapper, SysJobDo> implements ISysJobManage {

}
