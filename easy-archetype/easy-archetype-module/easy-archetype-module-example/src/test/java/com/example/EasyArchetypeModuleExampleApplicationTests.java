package com.example;


import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;

public class EasyArchetypeModuleExampleApplicationTests {


	@Test
	public void upload() {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
//文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
		paramMap.put("file", FileUtil.file("D:\\juejin.rar"));

		String post = HttpUtil.post("http://localhost:8080/file/upload/test", paramMap);
		System.out.println(post);
	}
}
