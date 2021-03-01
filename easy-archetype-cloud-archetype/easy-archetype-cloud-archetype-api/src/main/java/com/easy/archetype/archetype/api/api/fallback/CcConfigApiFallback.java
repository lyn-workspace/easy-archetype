package com.easy.archetype.archetype.api.api.fallback;

import com.easy.archetype.archetype.api.api.CcConfigApi;
import com.easy.archetype.archetype.api.vo.CcConfigVo;
import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import com.easy.archetype.framework.core.page.RespEntity;
import org.springframework.stereotype.Component;
/**
 * <p>
 *  api
 * </p>
 *
 * @author luyanan
 * @since 2021-03-01
*/
@Component
public class CcConfigApiFallback  implements CcConfigApi{

 @Override
 public RespEntity<PageInfo<CcConfigVo>> listByPage(PageRequestParams<CcConfigVo> pageRequestParams) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

  @Override
  public RespEntity<CcConfigVo> findById(Long id) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

   @Override
   public RespEntity add(CcConfigVo ccConfigVo) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

   @Override
   public RespEntity edit(CcConfigVo ccConfigVo) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

   @Override
   public RespEntity remove(Long[] ids) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

}
