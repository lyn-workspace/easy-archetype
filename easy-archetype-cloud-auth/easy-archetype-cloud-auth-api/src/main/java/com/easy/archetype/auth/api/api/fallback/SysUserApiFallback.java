package com.easy.archetype.auth.api.api.fallback;

import com.easy.archetype.auth.api.api.SysUserApi;
import com.easy.archetype.auth.api.vo.SysUserVo;
import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.page.RespEntity;
import org.springframework.stereotype.Component;

/**
 * SysUserApi的熔断
 *
 * @author luyanan
 * @since 2021/2/21
 **/
@Component
public class SysUserApiFallback implements SysUserApi {
	@Override
	public RespEntity<SysUserVo> findById(Long userId) {
		throw new BusinessException(IMsgCode.INTERNAL_SERVER_ERROR);
	}
}
