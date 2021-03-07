package com.easy.archetype.framework.core.extension;

import com.easy.archetype.framework.core.extension.annotation.SPI;

/**
 * 过滤器
 *
 * @author luyanan
 * @since 2021/3/5
 **/
@SPI("xxs")
public interface Filter {


	String filter(String content);
}
