package com.easy.archetype.archetype.web.service.impl;

import com.easy.archetype.archetype.api.vo.CcConfigVo;
import com.easy.archetype.archetype.web.entity.CcConfigDo;
import com.easy.archetype.archetype.web.manage.ICcConfigManage;
import com.easy.archetype.archetype.web.service.ICcConfigService;
import com.easy.archetype.common.utils.ConverUtils;
import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * serviceImpl
 * </p>
 *
 * @author luyanan
 * @since 2021-02-27
 */
@Service
public class CcConfigServiceImpl implements ICcConfigService {


	@Autowired
	private ICcConfigManage iCcConfigManage;


	@Override
	public PageInfo<CcConfigVo> listByPage(PageRequestParams<CcConfigVo> pageRequestParams) {
		PageRequestParams<CcConfigDo> requestParams = ConverUtils.converPageRequestParams(pageRequestParams, CcConfigDo.class);
		PageInfo<CcConfigDo> pageInfo = iCcConfigManage.listByPage(requestParams);
		return ConverUtils.converPageInfo(pageInfo, CcConfigVo.class);
	}

	@Override
	public List<CcConfigVo> list(CcConfigVo ccConfigVo) {
		CcConfigDo ccConfigDo = ConverUtils.conver(ccConfigVo, CcConfigDo.class);
		List<CcConfigDo> list = iCcConfigManage.list(ccConfigDo);
		return ConverUtils.listConver(list, CcConfigVo.class);
	}

	@Override
	public CcConfigVo findById(Long id) {
		CcConfigDo ccConfigDo = iCcConfigManage.findById(id);
		return ConverUtils.conver(ccConfigDo, CcConfigVo.class);
	}

	@Override
	public void insert(CcConfigVo ccConfigVo) {
		CcConfigDo ccConfigDo = ConverUtils.conver(ccConfigVo, CcConfigDo.class);
		iCcConfigManage.insert(ccConfigDo);
	}

	@Override
	public void update(CcConfigVo ccConfigVo) {
		CcConfigDo ccConfigDo = ConverUtils.conver(ccConfigVo, CcConfigDo.class);
		iCcConfigManage.update(ccConfigDo);
	}

	@Override
	public void deleteByIds(Collection<Long> ids) {
		iCcConfigManage.deleteBatch(ids);
	}
}
