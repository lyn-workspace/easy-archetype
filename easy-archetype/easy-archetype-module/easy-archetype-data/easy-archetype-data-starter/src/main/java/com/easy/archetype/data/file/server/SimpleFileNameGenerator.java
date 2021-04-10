package com.easy.archetype.data.file.server;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;

/**
 * 文件名生成简单实现
 *
 * @author luyanan
 * @since 2021/2/22
 **/
public class SimpleFileNameGenerator implements FileNameGenerator {
	@Override
	public String generate(String path, String fileName) {
		return IdUtil.fastSimpleUUID() + "." + FileUtil.extName(fileName);
	}
}
