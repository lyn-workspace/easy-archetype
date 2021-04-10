package com.easy.archetype.job.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.archetype.framework.page.PageInfo;
import com.easy.archetype.framework.page.PageRequestParams;
import com.easy.archetype.job.dao.JobLogDao;
import com.easy.archetype.job.entity.JobLogVo;
import com.easy.archetype.job.service.JobLogStorageStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 使用JDBC存储日志
 *
 * @author luyanan
 * @since 2021/3/20
 **/
public class JdbcJobLogStorageStrategy implements JobLogStorageStrategy {

	@Autowired
	private JobLogDao jobLogDao;


	@Override
	public PageInfo<JobLogVo> findByPage(PageRequestParams<JobLogVo> pageRequestParams) {
		return jobLogDao.selectByPage(pageRequestParams);
	}

	@Override
	public JobLogVo findById(String logId) {
		return jobLogDao.selectById(logId);
	}

	@Override
	public void save(JobLogVo jobLogVo) {
		if (StrUtil.isBlank(jobLogVo.getId())) {
			jobLogVo.setId(IdUtil.simpleUUID());
		}
		jobLogDao.insert(jobLogVo);
	}

	@Override
	public void deleteByIds(String[] ids) {
		jobLogDao.deleteByIds(ids);
	}

	@Override
	public void deleteById(String id) {

		jobLogDao.deleteById(id);
	}

	@Override
	public void clearLog() {

		jobLogDao.deleteAll();
	}
}
