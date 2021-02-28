package com.easy.archetype.framework.config;

import com.easy.archetype.framework.logger.LoggerProperties;
import com.easy.archetype.framework.thread.BusinessThreadPoolProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件
 *
 * @author luyanan
 * @since 2021/1/22
 **/
@Data
@ConfigurationProperties(EasyArchetypeFrameworkProperties.PREFIX)
public class EasyArchetypeFrameworkProperties {

	public static final String PREFIX = "easy.archetype.framework";

	/**
	 * 是否开启
	 *
	 * @author luyanan
	 * @since 2021/1/22
	 */
	private Boolean enable;

	/**
	 * 线程池配置
	 *
	 * @since 2021/1/22
	 */
	private BusinessThreadPoolProperties thread;

	/**
	 * redis的配置
	 *
	 * @since 2021/1/22
	 */
	private RedisProperties redis;

	/**
	 * 缓存的配置
	 *
	 * @since 2021/1/22
	 */
	private CacheProperties cache;

	/**
	 * Mybatis Plus的配置
	 *
	 * @since 2021/1/22
	 */
	private MybatisPlusProperties mybatisPlus;

	/**
	 * 日志的配置
	 *
	 * @since 2021/1/23
	 */
	private LoggerProperties logger;

	/**
	 * spring的配置
	 *
	 * @since 2021/1/24
	 */
	private SpringProperties spring;

	/**
	 * spring的配置
	 *
	 * @author luyanan
	 * @since 2021/1/24
	 */
	@Data
	public static class SpringProperties {

		/**
		 * 开启开关
		 *
		 * @since 2021/1/24
		 */
		private Boolean enable;

	}

	/**
	 * Mybatis Plus的配置
	 *
	 * @author luyanan
	 * @since 2021/1/22
	 */
	@Data
	public static class MybatisPlusProperties {

		/**
		 * 是否开启
		 *
		 * @since 2021/1/22
		 */
		private Boolean enable;

	}

	/**
	 * 缓存的配置
	 *
	 * @author luyanan
	 * @since 2021/1/22
	 */
	@Data
	public static class CacheProperties {

		/**
		 * 是否开启
		 *
		 * @since 2021/1/22
		 */
		private Boolean enable;

	}

	/**
	 * redis的配置
	 *
	 * @author luyanan
	 * @since 2021/1/22
	 */
	@Data
	public static class RedisProperties {

		private Boolean enable;

	}

}
