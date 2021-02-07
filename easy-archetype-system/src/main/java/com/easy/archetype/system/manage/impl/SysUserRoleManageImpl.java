package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl ;
import com.easy.archetype.system.mapper.SysUserRoleMapper ;
import com.easy.archetype.framework.manage.impl.ManageImpl ;
import com.easy.archetype.system.entity.SysUserRoleDo ;
import com.easy.archetype.system.manage.ISysUserRoleManage ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 用户和角色关联表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Service
public class SysUserRoleManageImpl extends ManageImpl<SysUserRoleMapper, SysUserRoleDo> implements ISysUserRoleManage {

}
