package  ${classPkg};

<#list   config.imports as import >
import ${import} ;
</#list>
/**
 *
 * ${entity.comment} service
 *
 *
 * @author ${author}
 * @since ${since}
*/
<#list  config.annotations as annotation>
${annotation}
</#list>
public interface ${className}  {

/**
* 分页查询
*
* @param pageRequestParams 分页参数
* @return PageInfo<${entityConfig.className}>
 * @since ${since}
 */
 PageInfo<${entityConfig.className}> listByPage(PageRequestParams<${entityConfig.className}> pageRequestParams);


   /**
   * 根据条件查询
   *
   * @param ${entityConfig.className?uncap_first} 根据条件查询
   * @return java.util.List<${entityConfig.className}>
    * @since ${since}
    */
    List<${entityConfig.className}> list(${entityConfig.className} ${entityConfig.className?uncap_first});

     /**
     * 根据id查询
     *
     * @param id id
     * @return ${entityConfig.className}
     * @since ${since}
     */
     ${entityConfig.className} findById(Long id);

     /**
     * 添加
     *
     * @param ${entityConfig.className?uncap_first} 实体
     * @return void
     * @since ${since}
     */
     void insert(${entityConfig.className} ${entityConfig.className?uncap_first});


     /**
     * 根据id修改
     *
     * @param ${entityConfig.className?uncap_first} 需要修改的对象
     * @return void
     * @since ${since}
     */
     void update(${entityConfig.className} ${entityConfig.className?uncap_first});


     /**
     * 根据id集合删除
     *
     * @param ids id集合
     * @return void
     * @since ${since}
     */
     void deleteByIds(Collection<Long> ids);

}