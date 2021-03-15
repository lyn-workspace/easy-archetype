package com.easy.archetype.archetype.web.service;

import com.easy.archetype.archetype.api.vo.CcConfigVo ;
import java.util.List ;
import com.easy.archetype.framework.page.PageInfo ;
import com.easy.archetype.framework.page.PageRequestParams ;
import java.util.Collection ;
/**
 *
 *  service
 *
 *
 * @author luyanan
 * @since 2021-03-01
*/
public interface ICcConfigService  {

/**
* 分页查询
*
* @param pageRequestParams 分页参数
* @return PageInfo<CcConfigVo>
 * @since 2021-03-01
 */
 PageInfo<CcConfigVo> listByPage(PageRequestParams<CcConfigVo> pageRequestParams);


   /**
   * 根据条件查询
   *
   * @param ccConfigVo 根据条件查询
   * @return java.util.List<CcConfigVo>
    * @since 2021-03-01
    */
    List<CcConfigVo> list(CcConfigVo ccConfigVo);

     /**
     * 根据id查询
     *
     * @param id id
     * @return CcConfigVo
     * @since 2021-03-01
     */
     CcConfigVo findById(Long id);

     /**
     * 添加
     *
     * @param ccConfigVo 实体
     * @return void
     * @since 2021-03-01
     */
     void insert(CcConfigVo ccConfigVo);


     /**
     * 根据id修改
     *
     * @param ccConfigVo 需要修改的对象
     * @return void
     * @since 2021-03-01
     */
     void update(CcConfigVo ccConfigVo);


     /**
     * 根据id集合删除
     *
     * @param ids id集合
     * @return void
     * @since 2021-03-01
     */
     void deleteByIds(Collection<Long> ids);

}