package com.easy.archetype.job.utils;

import com.easy.archetype.framework.spring.SpringContextHolder;
import com.easy.archetype.job.entity.JobVo;
import com.easy.archetype.job.invoke.JobInvokeFactory;
import com.easy.archetype.job.job.AbstractQuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;

/**
 * 定时任务处理(禁止并发执行)
 *
 * @author luyanan
 * @since 2021/3/14
 **/
@Slf4j
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {


	@Override
	protected void doExecute(JobExecutionContext jobExecutionContext, JobVo jobVo) throws Exception {
		JobInvokeFactory jobInvokeFactory = SpringContextHolder.getBean(JobInvokeFactory.class);
		jobInvokeFactory.jobInvokeStrategy(jobVo.getInvokeType()).invoke(jobVo);
	}
}
