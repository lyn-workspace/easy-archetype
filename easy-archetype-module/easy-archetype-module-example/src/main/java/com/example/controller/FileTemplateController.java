package com.example.controller;

import com.easy.archetype.framework.core.page.RespEntity;
import com.easy.archetype.framework.file.FileTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传测试类
 *
 * @author luyanan
 * @since 2021/2/25
 **/
@RestController
@RequestMapping(value = "file")
public class FileTemplateController {

	@Autowired
	private FileTemplate fileTemplate;

	@GetMapping("addHost")
	public RespEntity addHost() {
		String s = fileTemplate.addHost("111,111,111,111,111,111,111,111,111,");
		return RespEntity.success(s);
	}


	@PostMapping("upload")
	public RespEntity upload(MultipartFile file) {
		String upload = fileTemplate.upload(file, "/test");
		return RespEntity.success(upload);
	}

	@GetMapping("removeHost")
	public RespEntity removeHost(String path) {
		return RespEntity.success(fileTemplate.removeHost(path));
	}

	@GetMapping("removeFile")
	public RespEntity removeFile(String path) {
		return RespEntity.success(fileTemplate.removeFile(path));
	}


}
