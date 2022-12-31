package com.renkaen.cat_hospital.service.impl.security;

import com.renkaen.cat_hospital.bean.PO.Staff;
import com.renkaen.cat_hospital.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffMapper.selectStaffByName(username);//根据用户名查找用户
        //User 第一个参数用户名，第二个密码，第三个权限 List<String>
        //TODO 更改数据表，动态获取数据表
        List<String> permission = new ArrayList<>();
        permission.add("test1");
        permission.add("test2");
        Set<GrantedAuthority> GrantedAuthority = new HashSet<>();
        for (String p : permission) {
            GrantedAuthority.add(new SimpleGrantedAuthority(p));
        }
        if (staff != null) {
            return new User(staff.getUsername(), staff.getPassword(), GrantedAuthority);
        } else {
            throw new UsernameNotFoundException("当前用户不存在！");
        }
    }
}
