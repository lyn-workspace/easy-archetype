package com.easy.archetype.framework.mybatisplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * 自定义SQL注入器
 *
 * @author luyanan
 * @since 2021/1/20
 **/
public class MySqlInjector extends DefaultSqlInjector {

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {

		List<AbstractMethod> methodList = super.getMethodList(mapperClass);
		// 这里加入自己定义的一些方法
		return methodList;
	}

}
