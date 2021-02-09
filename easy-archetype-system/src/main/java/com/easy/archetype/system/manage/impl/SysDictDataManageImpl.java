package com.easy.archetype.system.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.archetype.framework.manage.impl.ManageImpl;
import com.easy.archetype.system.mapper.SysDictDataMapper;
import com.easy.archetype.system.manage.ISysDictDataManage;
import com.easy.archetype.system.entity.SysDictDataDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
@Service
public class SysDictDataManageImpl extends ManageImpl<SysDictDataMapper, SysDictDataDo> implements ISysDictDataManage {

}
