package com.easy.archetype.security.annotation;

import java.lang.annotation.*;

/**
 * Oauth2.0的客户端注解
 *
 * @author luyanan
 * @since 2021/2/18
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface EnableOauthClient {
}
