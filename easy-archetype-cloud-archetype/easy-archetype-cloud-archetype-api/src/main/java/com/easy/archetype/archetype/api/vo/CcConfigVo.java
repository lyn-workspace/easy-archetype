package com.easy.archetype.archetype.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * vo类
 *
 * @author luyanan
 * @since 2021/2/27
 **/
@ApiModel(value = "")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CcConfigVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	private Long id;

	/**
	 * 分组
	 */
	@ApiModelProperty(value = "分组")
	private String groupName;

	/**
	 * 配置的key
	 */
	@ApiModelProperty(value = "配置的key")
	private String configKey;

	/**
	 * 配置的value值
	 */
	@ApiModelProperty(value = "配置的value值")
	private String configValue;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
}
