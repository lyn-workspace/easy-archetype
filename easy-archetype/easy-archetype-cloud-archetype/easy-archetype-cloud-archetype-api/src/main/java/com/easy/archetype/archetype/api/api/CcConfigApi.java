package com.easy.archetype.archetype.api.api;

import com.easy.archetype.archetype.api.api.fallback.CcConfigApiFallback;
import com.easy.archetype.archetype.api.vo.CcConfigVo;
import com.easy.archetype.framework.page.PageInfo;
import com.easy.archetype.framework.page.PageRequestParams;
import com.easy.archetype.framework.page.RespEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * api
 * </p>
 *
 * @author luyanan
 * @since 2021-03-01
 */
@FeignClient(value = "applicationName", fallback = CcConfigApiFallback.class)
public interface CcConfigApi {
	String PREFIX = "cc/config";

	/**
	 * 分页查询
	 *
	 * @param pageRequestParams 分页参数
	 * @return com.easy.archetype.framework.core.RespEntity<com.easy.archetype.framework.core.PageInfo < com.easy.archetype.archetype.api.vo.CcConfigVo>>
	 * @since 2021-03-01
	 */
	@ApiOperation(value = "分页查询", response = CcConfigVo.class)
	@PostMapping(PREFIX + "/list")
	RespEntity<PageInfo<CcConfigVo>> listByPage(@RequestBody PageRequestParams<CcConfigVo> pageRequestParams);


	/**
	 * 根据id查询详情
	 *
	 * @param id id
	 * @return RespEntity<CcConfigVo>
	 * @since 2021-03-01
	 */
	@ApiOperation(value = "根据id查询详情", response = CcConfigVo.class)
	@GetMapping(value = PREFIX + "/{id}")
	RespEntity<CcConfigVo> findById(@PathVariable("id") Long id);


	/**
	 * 新增
	 *
	 * @param ccConfigVo ccConfigVo
	 * @return RespEntity
	 * @since 2021-03-01
	 */
	@ApiOperation(value = "新增")
	@PostMapping(PREFIX)
	RespEntity add(@Validated @RequestBody CcConfigVo ccConfigVo);

	/**
	 * 修改
	 *
	 * @param ccConfigVo ccConfigVo
	 * @return RespEntity
	 * @since 2021-03-01
	 */
	@ApiOperation(value = "修改")
	@PutMapping(PREFIX)
	RespEntity edit(@Validated @RequestBody CcConfigVo ccConfigVo);

	/**
	 * 根据id集合删除
	 *
	 * @param ids id删除
	 * @return RespEntity
	 * @since 2021-03-01
	 */
	@ApiOperation(value = "删除")
	@DeleteMapping(PREFIX + "/{ids}")
	RespEntity remove(@PathVariable("ids") Long[] ids);
}
