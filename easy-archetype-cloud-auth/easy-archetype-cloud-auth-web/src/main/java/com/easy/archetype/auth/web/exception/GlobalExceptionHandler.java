package com.easy.archetype.auth.web.exception;

import com.easy.archetype.common.exception.BusinessException;
import com.easy.archetype.common.exception.IMsgCode;
import com.easy.archetype.framework.core.RespEntity;
import com.easy.archetype.framework.spring.SpringContextHolder;
import com.easy.archetype.system.SystemMsgCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截
 *
 * @author luyanan
 * @since 2021/1/24
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 请求方法不支持
	 *
	 * @param e
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/1/24
	 */
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public RespEntity handleException(HttpRequestMethodNotSupportedException e) {
		log.error(e.getMessage(), e);
		return RespEntity.error(IMsgCode.HTTP_NOT_FOUND, e.getMethod());
	}

	/**
	 * 自定义校验异常
	 *
	 * @param e 异常
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/1/24
	 */
	@ExceptionHandler(BindException.class)
	public RespEntity validatedBindException(BindException e) {
		log.error(e.getMessage(), e);
		String message = e.getAllErrors().get(0).getDefaultMessage();
		return RespEntity.error(message);
	}

	/**
	 * 自定义异常
	 *
	 * @param request
	 * @param handlerMethod
	 * @param e
	 * @return java.lang.Object
	 * @since 2021/1/24
	 */
	@ExceptionHandler(BusinessException.class)
	public Object customerException(HttpServletRequest request, HandlerMethod handlerMethod, BusinessException e) {
		e.printStackTrace();
		if (SpringContextHolder.isBody(handlerMethod)) {
			// json请求
			return RespEntity.error(e.getCode());
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("errorMessage", e.getMessage());
			modelAndView.setViewName("error/business");
			return modelAndView;
		}
	}

	@ExceptionHandler(AccessDeniedException.class)
	public RespEntity accessDeniedException(AccessDeniedException e) {
		log.error(e.getMessage(), e);

		return RespEntity.error(SystemMsgCode.PERMISSION_DENIED);
	}

	/**
	 * 拦截未知异常
	 *
	 * @param e 异常信息
	 * @return com.easy.archetype.framework.core.RespEntity
	 * @since 2021/1/24
	 */
	@ExceptionHandler(Exception.class)
	public RespEntity handleException(RuntimeException e) {
		log.error(e.getMessage(), e);
		e.printStackTrace();
		return RespEntity.error(IMsgCode.INTERNAL_SERVER_ERROR);
	}

}
