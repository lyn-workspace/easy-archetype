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
@Component
public class ${className}  implements ${apiConfig.className}{

 @Override
 public RespEntity<PageInfo<${entityVoConfig.className}>> listByPage(PageRequestParams<${entityVoConfig.className}> pageRequestParams) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

  @Override
  public RespEntity<${entityVoConfig.className}> findById(Long id) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

   @Override
   public RespEntity add(${entityVoConfig.className} ${entityVoConfig.className?uncap_first}) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

   @Override
   public RespEntity edit(${entityVoConfig.className} ${entityVoConfig.className?uncap_first}) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

   @Override
   public RespEntity remove(${config.idFieldType}[] ids) {
   throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
   }

}
