package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl ;
import com.easy.archetype.framework.manage.impl.ManageImpl ;
import com.easy.archetype.system.manage.ISysDeptManage ;
import com.easy.archetype.system.entity.SysDeptDo ;
import com.easy.archetype.system.mapper.SysDeptMapper ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 部门表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Service
public class SysDeptManageImpl extends ManageImpl<SysDeptMapper, SysDeptDo> implements ISysDeptManage {

}
