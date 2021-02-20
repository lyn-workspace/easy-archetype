package com.easy.archetype.security.annotation;

import com.easy.archetype.security.oauth.server.OauthServerAutoConfiguration;
import com.easy.archetype.security.security.annotation.EnableSecurity;
import org.springframework.context.annotation.Import;

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
@EnableSecurity
@Import(OauthServerAutoConfiguration.class)
public @interface EnableOauthServer {
}
