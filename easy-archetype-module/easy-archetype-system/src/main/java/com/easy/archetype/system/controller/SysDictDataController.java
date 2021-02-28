package com.easy.archetype.system.controller;


import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import com.easy.archetype.framework.core.page.RespEntity;
import com.easy.archetype.system.entity.SysDictDataDo;
import com.easy.archetype.system.service.ISysDictDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据字典
 *
 * @author luyanan
 * @since 2021/2/11
 **/
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController {

	@Autowired
	private ISysDictDataService sysDictDataService;

	/**
	 * 根据字典类型查询字典数据信息
	 *
	 * @param dictType 字典类型
	 * @return com.easy.archetype.framework.core.page.RespEntity<java.util.List < com.easy.archetype.system.entity.SysDictDataDo>>
	 * @since 2021/2/11
	 */
	@GetMapping(value = "/type/{dictType}")
	public RespEntity<List<SysDictDataDo>> dictType(@PathVariable("dictType") String dictType) {
		List<SysDictDataDo> sysDictDataDos = sysDictDataService.list(SysDictDataDo.builder().dictType(dictType).build());
		return RespEntity.success(sysDictDataDos);
	}

	/**
	 * 列表查询
	 *
	 * @param pageRequestParams
	 * @return TableDataInfo
	 * @since 2021/2/14
	 */
	@ApiOperation(value = "列表查询")
	@PreAuthorize("@ss.hasPermi('system:dict:list')")
	@PostMapping("/list")
	public RespEntity<PageInfo<SysDictDataDo>> list(@RequestBody PageRequestParams<SysDictDataDo> pageRequestParams) {
		PageInfo<SysDictDataDo> pageInfo = sysDictDataService.findByPage(pageRequestParams);
		return RespEntity.success(pageInfo);
	}


	/**
	 * 新增
	 *
	 * @param dict
	 * @return com.easy.archetype.framework.core.page.RespEntity
	 * @since 2021/2/14
	 */
	@ApiOperation(value = "新增")
	@PreAuthorize("@ss.hasPermi('system:dict:add')")
	@PostMapping
	public RespEntity add(@Validated @RequestBody SysDictDataDo dict) {
		sysDictDataService.insert(dict);
		return RespEntity.success();
	}


	/**
	 * 修改
	 *
	 * @param dict
	 * @return com.easy.archetype.framework.core.page.RespEntity
	 * @since 2021/2/14
	 */
	@ApiOperation(value = "修改")
	@PreAuthorize("@ss.hasPermi('system:dict:edit')")
	@PutMapping
	public RespEntity edit(@Validated @RequestBody SysDictDataDo dict) {
		sysDictDataService.update(dict);
		return RespEntity.success();
	}

	/**
	 * 删除字典
	 *
	 * @param dictCodes
	 * @return com.easy.archetype.framework.core.page.RespEntity
	 * @since 2021/2/14
	 */
	@ApiOperation(value = "删除字典")
	@PreAuthorize("@ss.hasPermi('system:dict:remove')")
	@DeleteMapping("/{dictCodes}")
	public RespEntity remove(@PathVariable Long[] dictCodes) {
		sysDictDataService.deleteById(dictCodes);
		return RespEntity.success();
	}

}
