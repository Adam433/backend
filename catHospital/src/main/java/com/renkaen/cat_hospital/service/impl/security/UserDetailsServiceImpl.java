package com.renkaen.cat_hospital.service.impl.security;

import com.renkaen.cat_hospital.bean.DO.Permission;
import com.renkaen.cat_hospital.bean.DO.Roles;
import com.renkaen.cat_hospital.bean.DO.Staff;
import com.renkaen.cat_hospital.mapper.PermissionMapper;
import com.renkaen.cat_hospital.mapper.RolesMapper;
import com.renkaen.cat_hospital.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    UserDetailsImpl userDetails;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffMapper.selectStaffByName(username);//根据用户名查找用户
        if (staff != null) {
            //这里查询了一次数据库，拿到了所有的权限信息，可以根据权限信息整理出侧边栏的菜单结构
            List<Permission> permissions = permissionMapper.selectPermissionByRolesId(staff.getRoleId());
            List<Roles> roles = rolesMapper.selectByStaffId(staff.getStaffId());
            //菜单栏permissionsVO
            List<Permission> permissionsVO = new ArrayList<>();
            //权限信息
            List<String> authorities = new ArrayList<>();

            permissions.forEach(permission -> {
                authorities.add(permission.getUrl());
                if (permission.getPermissionColumn() == 0) {
                    List<Permission> list = new ArrayList<>();
                    for (Permission child : permissions) {
                        if (child.getPermissionColumn() == permission.getPermissionId()) {
                            list.add(child);
                        }
                    }
                    permission.setChildren(list);
                    permissionsVO.add(permission);
                }
            });
            for (Roles role : roles) {
                authorities.add(role.getRoleName());
            }
            System.out.println(authorities+"lkj");

            //UserDetails 第一个参数用户名，第二个密码，第三个权限 第四个侧边栏菜单
            return new UserDetailsImpl(staff.getUsername(), staff.getPassword(), authorities, permissionsVO);
        } else {
            throw new UsernameNotFoundException("当前用户不存在！");
        }
    }
}
