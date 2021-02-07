package com.easy.archetype.system.entity;

import java.util.Date ;
import  io.swagger.annotations.ApiModelProperty ;
import io.swagger.annotations.ApiModel ;
import com.baomidou.mybatisplus.annotation.* ;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@ApiModel(value = "字典类型表")
@TableName("sys_dict_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysDictTypeDo implements Serializable{

private static final long serialVersionUID = 1L;

    /**
    * 字典主键
    */
    @ApiModelProperty(value = "字典主键")
    @TableId(type = IdType.AUTO)
    private Long dictId;

    /**
    * 字典名称
    */
    @ApiModelProperty(value = "字典名称")
    private String dictName;

    /**
    * 字典类型
    */
    @ApiModelProperty(value = "字典类型")
    private String dictType;

    /**
    * 状态（0正常 1停用）
    */
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;

    /**
    * 创建者
    */
    @ApiModelProperty(value = "创建者")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
    * 更新者
    */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remark;



}
