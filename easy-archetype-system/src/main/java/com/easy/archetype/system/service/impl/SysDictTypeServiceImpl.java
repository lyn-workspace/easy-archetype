package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.manage.ISysDictTypeManage ;
import com.easy.archetype.system.service.ISysDictTypeService ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 字典类型表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Service
public class SysDictTypeServiceImpl  implements ISysDictTypeService {


   @Autowired
   private ISysDictTypeManage iSysDictTypeManage;


}
