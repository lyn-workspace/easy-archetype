package com.easy.archetype.archetype.web.manage.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl ;
import com.easy.archetype.framework.manage.impl.ManageImpl ;
import com.easy.archetype.archetype.web.mapper.CcConfigMapper ;
import com.easy.archetype.archetype.web.entity.CcConfigDo ;
import com.easy.archetype.archetype.web.manage.ICcConfigManage ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <p>
 *  manageImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-27
*/
@Service
public class CcConfigManageImpl extends ManageImpl<CcConfigMapper, CcConfigDo> implements ICcConfigManage {

}
