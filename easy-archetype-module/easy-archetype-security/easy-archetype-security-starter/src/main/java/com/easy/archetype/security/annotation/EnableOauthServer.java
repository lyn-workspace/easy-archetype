package com.easy.archetype.security.annotation;

import java.lang.annotation.*;

/**
 * oauth2.0的服务端注解
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface EnableOauthServer {
}
