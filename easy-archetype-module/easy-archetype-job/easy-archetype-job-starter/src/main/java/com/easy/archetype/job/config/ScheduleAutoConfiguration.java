package com.easy.archetype.job.config;

import com.easy.archetype.framework.jdbc.JdbcExecutor;
import com.easy.archetype.job.controller.JobController;
import com.easy.archetype.job.controller.JobLogController;
import com.easy.archetype.job.dao.JobDao;
import com.easy.archetype.job.dao.JobLogDao;
import com.easy.archetype.job.invoke.JobInvokeFactory;
import com.easy.archetype.job.invoke.JobInvokeStrategy;
import com.easy.archetype.job.invoke.SpringBeanJobInvokeStrategy;
import com.easy.archetype.job.service.JobLogStorageStrategy;
import com.easy.archetype.job.service.JobService;
import com.easy.archetype.job.service.impl.JdbcJobLogStorageStrategy;
import com.easy.archetype.job.service.impl.JobServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * 定时任务自动注入
 *
 * @author luyanan
 * @since 2021/3/20
 **/
@ConditionalOnProperty(prefix = JobProperties.PREFIX, name = "enable", havingValue = "true", matchIfMissing = false)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(JobProperties.class)
@Import(ScheduleConfig.class)
public class ScheduleAutoConfiguration {

	@Bean
	public JdbcExecutor jdbcExecutor(DataSource dataSource) {
		JdbcExecutor jdbcExecutor = new JdbcExecutor();
		jdbcExecutor.setDataSource(dataSource);
		return jdbcExecutor;
	}


	@Bean
	public JobDao jobDao() {
		return new JobDao();
	}

	@Bean
	public JobLogDao jobLogDao() {
		return new JobLogDao();
	}


	@Bean
	public JobInvokeStrategy springBeanJobInvokeStrategy() {
		return new SpringBeanJobInvokeStrategy();
	}

	@Bean
	public JobInvokeFactory jobInvokeFactory() {
		return new JobInvokeFactory();
	}

	@Bean
	public JobLogStorageStrategy jobLogStorageStrategy() {
		return new JdbcJobLogStorageStrategy();
	}

	@Bean
	public JobService jobService() {
		return new JobServiceImpl();
	}


	@Bean
	public JobController jobController() {
		return new JobController();
	}

	@Bean
	public JobLogController jobLogController() {
		return new JobLogController();
	}
}
