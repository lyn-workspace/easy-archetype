package com.easy.archetype.job.service;

import com.easy.archetype.framework.page.PageInfo;
import com.easy.archetype.framework.page.PageRequestParams;
import com.easy.archetype.job.entity.JobLogVo;

import java.util.Collection;

/**
 * 日志处理
 *
 * @author luyanan
 * @since 2021/3/14
 **/
public interface JobLogService {


	/**
	 * 根据id查询
	 *
	 * @param id
	 * @return com.easy.archetype.job.entity.JobLogVo
	 * @since 2021/3/14
	 */
	JobLogVo selectById(Long id);


	/**
	 * 添加任务
	 *
	 * @param jobLogVo
	 * @return void
	 * @since 2021/3/14
	 */
	void addLog(JobLogVo jobLogVo);


	/**
	 * 分页查询
	 *
	 * @param pageRequestParams 分页条件
	 * @return com.easy.archetype.framework.core.page.PageInfo<com.easy.archetype.job.entity.JobLogVo>
	 * @since 2021/3/14
	 */
	PageInfo<JobLogVo> selectByPage(PageRequestParams<JobLogVo> pageRequestParams);


	/**
	 * 根据id集合删除
	 *
	 * @param idList
	 * @return void
	 * @since 2021/3/14
	 */
	void deleteByIds(Collection<Long> idList);


	/**
	 * 清空任务日志
	 *
	 * @return void
	 * @since 2021/3/14
	 */
	void cleanJobLog();
}
