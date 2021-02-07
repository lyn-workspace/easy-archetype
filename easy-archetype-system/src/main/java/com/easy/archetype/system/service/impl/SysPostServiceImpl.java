package com.easy.archetype.system.service.impl;

import com.easy.archetype.system.service.ISysPostService ;
import com.easy.archetype.system.manage.ISysPostManage ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 岗位信息表 serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Service
public class SysPostServiceImpl  implements ISysPostService {


   @Autowired
   private ISysPostManage iSysPostManage;


}
