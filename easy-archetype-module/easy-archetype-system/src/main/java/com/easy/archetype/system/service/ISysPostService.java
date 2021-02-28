package com.easy.archetype.system.service;

import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import com.easy.archetype.system.entity.SysPostDo;

import java.util.List;

/**
 * <p>
 * 岗位信息表 service
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
 */
public interface ISysPostService {

	/**
	 * 根据条件查询
	 *
	 * @param sysPostDo 实体条件
	 * @return java.util.List<com.easy.archetype.system.entity.SysPostDo>
	 * @since 2021/2/12
	 */
	List<SysPostDo> list(SysPostDo sysPostDo);

	/**
	 * 根据用户id查询岗位
	 *
	 * @param userId 用户id
	 * @return java.util.List<com.easy.archetype.system.entity.SysPostDo>
	 * @since 2021/2/12
	 */
	List<SysPostDo> listByUserId(Long userId);

	/**
	 * 分页查询
	 *
	 * @param pageRequestParams 分页参数
	 * @return com.easy.archetype.framework.core.page.PageInfo<com.easy.archetype.system.entity.SysPostDo>
	 * @since 2021/2/14
	 */
	PageInfo<SysPostDo> findByPage(PageRequestParams<SysPostDo> pageRequestParams);

	/**
	 * 根据id查询岗位详情
	 *
	 * @param postId
	 * @return com.easy.archetype.system.entity.SysPostDo
	 * @since 2021/2/14
	 */
	SysPostDo findById(Long postId);

	/**
	 * 新增岗位
	 *
	 * @param post
	 * @return void
	 * @since 2021/2/14
	 */
	void insert(SysPostDo post);

	/**
	 * 岗位修改
	 *
	 * @param post
	 * @return void
	 * @since 2021/2/14
	 */
	void update(SysPostDo post);

	/**
	 * 根据id批量删除
	 *
	 * @param ids id集合
	 * @return void
	 * @since 2021/2/14
	 */
	void deleteByIds(List<Long> ids);
}
