package com.easy.archetype.job.dao;

import com.easy.archetype.framework.jdbc.EntityWrapper;
import com.easy.archetype.framework.jdbc.JdbcExecutor;
import com.easy.archetype.framework.page.PageInfo;
import com.easy.archetype.framework.page.PageRequestParams;
import com.easy.archetype.job.entity.JobVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 任务Dao
 *
 * @author luyanan
 * @since 2021/3/20
 **/
public class JobDao {
	@Autowired
	private JdbcExecutor jdbcExecutor;

	/**
	 * 查询任务
	 *
	 * @param jobVo
	 * @return java.util.List<com.easy.archetype.job.entity.JobVo>
	 * @since 2021/3/20
	 */
	public List<JobVo> selectList(JobVo jobVo) {
		return jdbcExecutor.selectList(new EntityWrapper<>(jobVo), JobVo.class);
	}

	/**
	 * 分页查询
	 *
	 * @param pageRequestParams
	 * @return com.easy.archetype.framework.page.PageInfo<com.easy.archetype.job.entity.JobVo>
	 * @since 2021/3/20
	 */
	public PageInfo<JobVo> selectByPage(PageRequestParams<JobVo> pageRequestParams) {
		return jdbcExecutor.selectByPage(pageRequestParams, JobVo.class);
	}

	/**
	 * 根据id查询
	 *
	 * @param jobId 任务id
	 * @return com.easy.archetype.job.entity.JobVo
	 * @since 2021/3/20
	 */
	public JobVo selectById(String jobId) {
		return jdbcExecutor.selectById(jobId, JobVo.class);
	}

	/**
	 * 修改
	 *
	 * @param jobVo
	 * @return int
	 * @since 2021/3/20
	 */
	public int update(JobVo jobVo) {
		return jdbcExecutor.updateById(jobVo);
	}

	/**
	 * 根据id删除
	 *
	 * @param jobId 任务id
	 * @return int
	 * @since 2021/3/20
	 */
	public int delete(String jobId) {
		return jdbcExecutor.deleteById(jobId, JobVo.class);
	}

	/**
	 * 插入
	 *
	 * @param jobVo
	 * @return int
	 * @since 2021/3/20
	 */
	public int insert(JobVo jobVo) {
		return jdbcExecutor.insert(jobVo);
	}
}
