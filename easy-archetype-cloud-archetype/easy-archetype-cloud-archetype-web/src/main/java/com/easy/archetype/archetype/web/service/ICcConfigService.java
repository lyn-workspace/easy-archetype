package com.easy.archetype.archetype.web.service;

import com.easy.archetype.archetype.api.vo.CcConfigVo;
import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-27
 */
public interface ICcConfigService {


	/**
	 * 分页查询
	 *
	 * @param pageRequestParams 分页参数
	 * @return com.easy.archetype.framework.core.page.PageInfo<com.easy.archetype.archetype.api.vo.CcConfigVo>
	 * @since 2021/2/27
	 */
	PageInfo<CcConfigVo> listByPage(PageRequestParams<CcConfigVo> pageRequestParams);


	/**
	 * 根据条件查询
	 *
	 * @param ccConfigVo 根据条件查询
	 * @return java.util.List<com.easy.archetype.archetype.api.vo.CcConfigVo>
	 * @since 2021/2/27
	 */
	List<CcConfigVo> list(CcConfigVo ccConfigVo);

	/**
	 * 根据id查询
	 *
	 * @param id id
	 * @return com.easy.archetype.archetype.api.vo.CcConfigVo
	 * @since 2021/2/27
	 */
	CcConfigVo findById(Long id);

	/**
	 * 添加
	 *
	 * @param ccConfigVo 实体
	 * @return void
	 * @since 2021/2/27
	 */
	void insert(CcConfigVo ccConfigVo);


	/**
	 * 根据id修改
	 *
	 * @param ccConfigVo 需要修改的对象
	 * @return void
	 * @since 2021/2/27
	 */
	void update(CcConfigVo ccConfigVo);


	/**
	 * 根据id集合删除
	 *
	 * @param ids id集合
	 * @return void
	 * @since 2021/2/27
	 */
	void deleteByIds(Collection<Long> ids);


}


