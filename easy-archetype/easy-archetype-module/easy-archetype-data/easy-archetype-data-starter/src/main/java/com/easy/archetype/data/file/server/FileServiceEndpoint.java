package com.easy.archetype.data.file.server;

import com.easy.archetype.framework.page.RespEntity;
import com.easy.archetype.data.file.IFileService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务模块端点
 *
 * @author luyanan
 * @since 2021/2/26
 **/
@RestController
@RequestMapping("file")
public class FileServiceEndpoint {

	@Autowired
	private IFileService fileService;

	/**
	 * 文件上传
	 *
	 * @param path   上传的文件路径
	 * @param file   文件
	 * @param rename 是否需要重命名
	 * @return com.easy.archetype.framework.core.page.RespEntity
	 * @since 2021/2/26
	 */
	@SneakyThrows
	@PostMapping("/upload/{path}")
	public RespEntity upload(@PathVariable("path") String path, @RequestParam("file") MultipartFile file,
							 @RequestParam(value = "rename", required = false, defaultValue = "true") Boolean rename) {
		String upload = fileService.upload(path, file.getOriginalFilename(), file.getInputStream(), rename);
		return RespEntity.success(upload);
	}


	/**
	 * 文件删除
	 *
	 * @param path 文件路径
	 * @return com.easy.archetype.framework.core.page.RespEntity
	 * @since 2021/2/26
	 */
	@GetMapping("remove/{path}")
	public RespEntity removeFile(@PathVariable("path") String path) {
		fileService.removeFile(path);
		return RespEntity.success();
	}
}
