package com.renkaen.cat_hospital.bean.DO;

import com.renkaen.cat_hospital.service.impl.security.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 一个用于存储在redis中的StaffToken对象
 * 原因：UserDetailsImpl对象存入redis后无法还原
 */
public class StaffToken implements Serializable {
    private String password;
    private  String username;
    private  List<String> authorities;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;

    public StaffToken(UserDetailsImpl user){
        List<String> list = new ArrayList<>();
        for (GrantedAuthority authority : user.getAuthorities()) {
            list.add(authority.toString());
        }
        password = "PROTECTED";
        username = user.getUsername();
        authorities = list;
        accountNonExpired=user.isAccountNonExpired();
        accountNonLocked = user.isAccountNonLocked();
        credentialsNonExpired = user.isCredentialsNonExpired();
        enabled = user.isEnabled();
    }
    public StaffToken(String username, List<String> authorities){
        this.username = username;
        this.authorities =authorities;
        accountNonExpired=true;
        accountNonLocked=true;
        credentialsNonExpired=true;
        enabled=true;
    }
}
