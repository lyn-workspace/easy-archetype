package com.easy.archetype.system.mapper;

import com.easy.archetype.framework.mybatisplus.BaseMapperPlus ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper ;
import org.apache.ibatis.annotations.Mapper ;
import com.easy.archetype.system.entity.SysDictDataDo ;
/**
 * <p>
 * 字典数据表 mapper
 * </p>
 *
 * @author luyanan
 * @since 2021-02-03
*/
@Mapper
public interface SysDictDataMapper extends BaseMapperPlus<SysDictDataDo> {


}
