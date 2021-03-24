package com.easy.archetype.job.utils;

import com.easy.archetype.job.entity.JobVo;
import com.easy.archetype.job.invoke.JobInvokeFactory;
import com.easy.archetype.job.job.AbstractQuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定时任务处理(禁止并发执行)
 *
 * @author luyanan
 * @since 2021/3/14
 **/
@Slf4j
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {

	@Autowired
	private JobInvokeFactory invokeFactory;

	@Override
	protected void doExecute(JobExecutionContext jobExecutionContext, JobVo jobVo) throws Exception {
		invokeFactory.jobInvokeStrategy(jobVo.getInvokeType()).invoke(jobVo);
	}
}
