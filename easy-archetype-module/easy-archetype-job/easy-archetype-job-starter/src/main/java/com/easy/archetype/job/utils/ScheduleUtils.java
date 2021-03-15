package com.easy.archetype.job.utils;

import com.easy.archetype.job.entity.JobVo;
import org.quartz.Job;

/**
 * 定时任务工具类
 *
 * @author luyanan
 * @since 2021/3/14
 **/
public class ScheduleUtils {

	private static Class<? extends Job> getQuartzJobClass(JobVo sysJob) {
		boolean isConcurrent = "0".equals(sysJob.getConcurrent());
		return isConcurrent ? QuartzJobExecution.class : QuartzDisallowConcurrentExecution.class;
	}
}
