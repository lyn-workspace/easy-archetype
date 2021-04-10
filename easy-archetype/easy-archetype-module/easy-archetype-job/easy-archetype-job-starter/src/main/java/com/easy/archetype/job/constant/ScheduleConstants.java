package com.easy.archetype.job.constant;

/**
 * 任务调度 常量
 *
 * @author luyanan
 * @since 2021/3/14
 **/
public class ScheduleConstants {
	public static final String TASK_CLASS_NAME = "TASK_CLASS_NAME";

	/**
	 * 执行目标key
	 */
	public static final String TASK_PROPERTIES = "TASK_PROPERTIES";

	/**
	 * 默认
	 */
	public static final String MISFIRE_DEFAULT = "0";

	/**
	 * 立即触发执行
	 */
	public static final String MISFIRE_IGNORE_MISFIRES = "1";

	/**
	 * 触发一次执行
	 */
	public static final String MISFIRE_FIRE_AND_PROCEED = "2";

	/**
	 * 不触发立即执行
	 */
	public static final String MISFIRE_DO_NOTHING = "3";

	/**
	 * 通用成功标识
	 */
	public static final String SUCCESS = "0";

	/**
	 * 通用失败标识
	 */
	public static final String FAIL = "1";


	public enum Status {
		/**
		 * 正常
		 */
		NORMAL("0"),
		/**
		 * 暂停
		 */
		PAUSE("1");

		private String value;

		private Status(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

}
