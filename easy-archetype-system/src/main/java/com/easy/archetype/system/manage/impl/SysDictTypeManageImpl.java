package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.archetype.framework.manage.impl.ManageImpl;
import com.easy.archetype.system.mapper.SysDictTypeMapper;
import com.easy.archetype.system.manage.ISysDictTypeManage;
import com.easy.archetype.system.entity.SysDictTypeDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysDictTypeManageImpl extends ManageImpl<SysDictTypeMapper, SysDictTypeDo> implements ISysDictTypeManage {

}
