package com.renkaen.cat_hospital.service.impl.security;

import com.alibaba.druid.sql.visitor.functions.Right;
import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.VO.RightVO;
import com.renkaen.cat_hospital.bean.VO.StaffJoinRightsVO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//相当于原生中的User 但是需要将侧边栏信息在登陆时传给前端
@Component
@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String password;
    private Integer id;
    private  String username;
    private List<String> authorities;
    private StaffJoinRightsVO rights;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;

    public UserDetailsImpl(String username, String password, List<String> authorities, StaffJoinRightsVO staffJoinRightsVO){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.rights = staffJoinRightsVO;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.id = id;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (String authority : authorities) {
            list.add( new SimpleGrantedAuthority(authority));
        }
        return list;
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
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
