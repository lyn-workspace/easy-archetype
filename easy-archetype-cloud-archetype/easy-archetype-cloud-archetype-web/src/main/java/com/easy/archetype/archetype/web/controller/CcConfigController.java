package com.easy.archetype.archetype.web.controller;

import com.easy.archetype.archetype.api.vo.CcConfigVo;
import com.easy.archetype.archetype.web.service.ICcConfigService;
import com.easy.archetype.framework.core.page.PageInfo;
import com.easy.archetype.framework.core.page.PageRequestParams;
import com.easy.archetype.framework.core.page.RespEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
/**
 * <p>
 *  controller
 * </p>
 *
 * @author luyanan
 * @since 2021-03-01
*/
@Api(tags = "")
@RestController
@RequestMapping("cc/config")
public class CcConfigController {
    /**
    * 权限前缀
    *
    * @since 2021-03-01
    */
   private static final String PERMISS_PREFIX = "cc/config";

    @Autowired
    private ICcConfigService iCcConfigService;

    /**
    * 分页查询
    *
    * @param pageRequestParams 分页参数
    * @return RespEntity<PageInfo<CcConfigVo>>
    * @since 2021-03-01
    */
    @ApiOperation(value = "分页查询", response = CcConfigVo.class)
    @PreAuthorize("@ss.hasPermi('" + PERMISS_PREFIX + "list')")
    @PostMapping("/list")
    public RespEntity<PageInfo<CcConfigVo>> listByPage(@RequestBody PageRequestParams<CcConfigVo> pageRequestParams) {
        PageInfo<CcConfigVo> pageInfo = iCcConfigService.listByPage(pageRequestParams);
        return RespEntity.success(pageInfo);
    }

    /**
    * 根据id查询详情
    *
    * @param id id
    * @return RespEntity<CcConfigVo>
    * @since 2021-03-01
    */
    @ApiOperation(value = "根据id查询详情", response = CcConfigVo.class)
    @PreAuthorize("@ss.hasPermi('" + PERMISS_PREFIX + "query')")
    @GetMapping(value = "/{id}")
    public RespEntity<CcConfigVo> findById(@PathVariable("id") Long id) {
        CcConfigVo ccConfigVo = iCcConfigService.findById(id);
        return RespEntity.success(ccConfigVo);
    }

    /**
    * 新增
    *
    * @param ccConfigVo ccConfigVo
    * @return RespEntity
    * @since 2021-03-01
    */
    @ApiOperation(value = "新增")
    @PreAuthorize("@ss.hasPermi('" + PERMISS_PREFIX + "add')")
    @PostMapping()
    public RespEntity add(@Validated @RequestBody CcConfigVo ccConfigVo) {
        iCcConfigService.insert(ccConfigVo);
        return RespEntity.success();
    }

    /**
    * 修改
    *
    * @param ccConfigVo ccConfigVo
    * @return RespEntity
    * @since 2021-03-01
    */
    @ApiOperation(value = "修改")
    @PreAuthorize("@ss.hasPermi('" + PERMISS_PREFIX + "edit')")
    @PutMapping
    public RespEntity edit(@Validated @RequestBody CcConfigVo ccConfigVo) {
        iCcConfigService.update(ccConfigVo);
        return RespEntity.success();
    }

    /**
    * 根据id集合删除
    *
    * @param ids id删除
    * @return RespEntity
    * @since 2021-03-01
    */
    @ApiOperation(value = "删除")
    @PreAuthorize("@ss.hasPermi('" + PERMISS_PREFIX + "remove')")
    @DeleteMapping("/{ids}")
    public RespEntity remove(@PathVariable("ids") Long[] ids) {
        iCcConfigService.deleteByIds(Arrays.asList(ids));
        return RespEntity.success();
    }
}
