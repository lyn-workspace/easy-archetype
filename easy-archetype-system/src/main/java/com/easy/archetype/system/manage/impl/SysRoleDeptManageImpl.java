package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.archetype.framework.manage.impl.ManageImpl;
import com.easy.archetype.system.entity.SysRoleDeptDo;
import com.easy.archetype.system.manage.ISysRoleDeptManage;
import com.easy.archetype.system.mapper.SysRoleDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysRoleDeptManageImpl extends ManageImpl<SysRoleDeptMapper, SysRoleDeptDo> implements ISysRoleDeptManage {

}
