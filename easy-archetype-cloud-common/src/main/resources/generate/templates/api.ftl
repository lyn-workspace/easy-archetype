package  ${classPkg};

<#list   config.imports as import >
import ${import} ;
</#list>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 * ${entity.comment} api
 * </p>
 *
 * @author ${author}
 * @since ${since}
*/
<#list  config.annotations as annotation>
 ${annotation}
</#list>
@FeignClient(value = "applicationName", fallback = ${className}Back.class)
public interface ${className} {
String PREFIX = "cc/config";

/**
* 分页查询
*
* @param pageRequestParams 分页参数
* @return com.easy.archetype.framework.core.RespEntity<com.easy.archetype.framework.core.PageInfo < com.easy.archetype.archetype.api.vo.${entityVoConfig.className}>>
* @since ${since}
*/
@ApiOperation(value = "分页查询", response = ${entityVoConfig.className}.class)
@PostMapping(PREFIX + "/list")
RespEntity<PageInfo<${entityVoConfig.className}>> listByPage(@RequestBody PageRequestParams<${entityVoConfig.className}> pageRequestParams);


  /**
  * 根据id查询详情
  *
  * @param id id
  * @return RespEntity<${entityVoConfig.className}>
   * @since ${since}
   */
   @ApiOperation(value = "根据id查询详情", response = ${entityVoConfig.className}.class)
   @GetMapping(value = PREFIX + "/{id}")
   RespEntity<${entityVoConfig.className}> findById(@PathVariable("id") Long id);


    /**
    * 新增
    *
    * @param ${entityVoConfig.className?uncap_first} ${entityVoConfig.className?uncap_first}
    * @return RespEntity
    * @since ${since}
    */
    @ApiOperation(value = "新增")
    @PostMapping(PREFIX)
    RespEntity add(@Validated @RequestBody ${entityVoConfig.className} ${entityVoConfig.className?uncap_first});

    /**
    * 修改
    *
    * @param ${entityVoConfig.className?uncap_first} ${entityVoConfig.className?uncap_first}
    * @return RespEntity
    * @since ${since}
    */
    @ApiOperation(value = "修改")
    @PutMapping(PREFIX)
    RespEntity edit(@Validated @RequestBody ${entityVoConfig.className} ${entityVoConfig.className?uncap_first});

    /**
    * 根据id集合删除
    *
    * @param ids id删除
    * @return RespEntity
    * @since ${since}
    */
    @ApiOperation(value = "删除")
    @DeleteMapping(PREFIX + "/{ids}")
    RespEntity remove(@PathVariable("ids") ${config.idFieldType}[] ids);
}
