package com.easy.archetype.auth.web.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.easy.archetype.common.user.LoginUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MybatsPlus 字段填充
 *
 * @author luyanan
 * @since 2021/2/15
 **/
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Autowired
	private LoginUserService loginUserService;

	@Override
	public void insertFill(MetaObject metaObject) {

		log.debug("插入字段填充:{}", metaObject.getOriginalObject());
		Long userId = loginUserService.getUserId();
		this.strictInsertFill(metaObject, "createTime", () -> new Date(), Date.class);
		this.strictInsertFill(metaObject, "createBy", () -> userId, Long.class);
		this.strictInsertFill(metaObject, "updateTime", () -> new Date(), Date.class);
		this.strictInsertFill(metaObject, "updateBy", () -> userId, Long.class);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.debug("修改字段填充:{}", metaObject.getOriginalObject());
		Long userId = loginUserService.getUserId();
		this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class);
		this.strictUpdateFill(metaObject, "updateBy", () -> userId, Long.class);
	}
}
