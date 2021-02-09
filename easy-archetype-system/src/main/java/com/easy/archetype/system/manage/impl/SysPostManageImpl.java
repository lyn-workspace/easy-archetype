package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.archetype.framework.manage.impl.ManageImpl;
import com.easy.archetype.system.entity.SysPostDo;
import com.easy.archetype.system.mapper.SysPostMapper;
import com.easy.archetype.system.manage.ISysPostManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysPostManageImpl extends ManageImpl<SysPostMapper, SysPostDo> implements ISysPostManage {

}
