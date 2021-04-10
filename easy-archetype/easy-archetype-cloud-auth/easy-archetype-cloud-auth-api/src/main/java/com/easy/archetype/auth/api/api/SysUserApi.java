package com.easy.archetype.auth.api.api;

import com.easy.archetype.auth.api.api.fallback.SysUserApiFallback;
import com.easy.archetype.auth.api.vo.SysUserVo;
import com.easy.archetype.framework.page.RespEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户的接口
 *
 * @author luyanan
 * @since 2021/2/21
 **/
@FeignClient(value = "easy-archetype-cloud-auth", fallback = SysUserApiFallback.class)
public interface SysUserApi {


	/**
	 * 根据id查询详情
	 *
	 * @param userId 用户id
	 * @return com.easy.archetype.framework.core.page.RespEntity<com.easy.archetype.system.vo.SysUserVo>
	 * @since 2021/2/21
	 */
	@ApiOperation(value = "根据id查询详情")
	@GetMapping("/uaa/system/user/find/id/{userId}")
	RespEntity<SysUserVo> findById(@PathVariable("userId") Long userId);
}
