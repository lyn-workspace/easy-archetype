package com.easy.archetype.job.invoke;

import cn.hutool.core.lang.Assert;
import com.easy.archetype.job.exception.JobException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 任务调用工厂
 *
 * @author luyanan
 * @since 2021/3/18
 **/
public class JobInvokeFactory {

	@Autowired
	private ObjectProvider<JobInvokeStrategy> jobInvokeStrategies;


	public JobInvokeStrategy jobInvokeStrategy(String type) {
		Assert.notBlank(type, "任务调用类型不能为空");
		return jobInvokeStrategies
				.stream()
				.filter(a -> a.type().equals(type))
				.findFirst().orElseThrow(() -> new JobException("没有找见[" + type + "]的执行器"));
	}

}
