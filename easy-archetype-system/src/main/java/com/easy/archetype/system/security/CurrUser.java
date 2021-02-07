package com.easy.archetype.system.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 当前用户
 *
 * @author luyanan
 * @since 2021/1/30
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrUser implements UserDetails {
    /**
     * 用户名
     *
     * @since 2021/1/30
     */
    private String username;
    /**
     * 密码
     *
     * @since 2021/1/30
     */
    private String password;
    /**
     * 是否启用
     *
     * @since 2021/1/30
     */
    private boolean enabled;

    /**
     * 权限列表
     *
     * @since 2021/1/30
     */
    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
