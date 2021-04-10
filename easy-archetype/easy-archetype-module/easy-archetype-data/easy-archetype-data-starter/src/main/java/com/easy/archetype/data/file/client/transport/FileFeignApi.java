package com.easy.archetype.data.file.client.transport;

import com.easy.archetype.framework.page.RespEntity;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件Feign接口
 *
 * @author luyanan
 * @since 2021/2/26
 **/
public interface FileFeignApi {

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
	RespEntity upload(@PathVariable("path") String path, @RequestParam("file") MultipartFile file,
					  @RequestParam(value = "rename", required = false, defaultValue = "true") Boolean rename);


	/**
	 * 文件删除
	 *
	 * @param path 文件路径
	 * @return com.easy.archetype.framework.core.page.RespEntity
	 * @since 2021/2/26
	 */
	@GetMapping("remove/{path}")
	RespEntity removeFile(@PathVariable("path") String path);
}
