package com.easy.archetype.job.job;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.easy.archetype.job.constant.ScheduleConstants;
import com.easy.archetype.job.entity.JobLogVo;
import com.easy.archetype.job.entity.JobVo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 抽象quartz调用
 *
 * @author luyanan
 * @since 2021/3/14
 **/
@Slf4j
public class AbstractQuartzJob implements BaseJob {

	private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobVo jobVo = new JobVo();
		BeanUtils.copyProperties(jobVo, context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES));


	}

	@Override
	public void before(JobExecutionContext context, JobVo jobVo) {
		threadLocal.set(new Date());
	}

	@Override
	public void after(JobExecutionContext context, JobVo jobVo, Exception e) {
		Date startTime = threadLocal.get();
		threadLocal.remove();
		JobLogVo logVo = new JobLogVo();
		logVo.setJobName(jobVo.getJobName());
		logVo.setJobGroup(jobVo.getJobGroup());
		logVo.setJobLogId(jobVo.getJobId());
		logVo.setInvokeTarget(jobVo.getInvokeTarget());
		logVo.setStartTime(startTime);
		logVo.setEndTime(new Date());
		long runMs = logVo.getEndTime().getTime() - logVo.getStartTime().getTime();
		logVo.setJobMessage(logVo.getJobName() + " 总共耗时：" + runMs + "毫秒");
		if (null != e) {
			logVo.setStatus(ScheduleConstants.FAIL);
			logVo.setExceptionInfo(ExceptionUtil.getMessage(e));
		} else {
			logVo.setStatus(ScheduleConstants.SUCCESS);
		}


	}
}
