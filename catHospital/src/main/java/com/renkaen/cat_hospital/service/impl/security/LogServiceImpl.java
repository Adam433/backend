package com.renkaen.cat_hospital.service.impl.security;

import com.renkaen.cat_hospital.bean.PO.Staff;
import com.renkaen.cat_hospital.bean.PO.StaffToken;
import com.renkaen.cat_hospital.domain.ResponseResult;
import com.renkaen.cat_hospital.service.LogService;
import com.renkaen.cat_hospital.utils.JwtUtil;
import com.renkaen.cat_hospital.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisUtil redisCache;

    public ResponseResult login(Staff staff) {
        //1. 生成一个token进行验证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(staff.getUsername(),staff.getPassword());
        //2. 认证的主要策略接口是AuthenticationManager，只有一个方法Authentication
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //如果验证结果为null（不通过）；抛出异常（无法确定是否通过）
        if(Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误");
        }
        System.out.println(authentication.getPrincipal());
        //拿到验证结果中的userDetail，在UserDetails类中可以设置
        User user = (User) authentication.getPrincipal();
        StaffToken staffToken = new StaffToken(user);
        //将用户名和密码加密到jwt中生成token
        String jwt = JwtUtil.creatJwt(staffToken.getUsername());
        //userDetails存入redis，
        redisCache.setCacheObject("login:"+staffToken.getUsername(),staffToken);
        //jwt中生成的token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        //拿到当前线程认证信息authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //拿到认证信息中的User
        StaffToken staffToken  = (StaffToken) authentication.getPrincipal();
        redisCache.deleteObject("login:"+staffToken.getUsername());
        return new ResponseResult(200,"退出登陆成功");
    }
}
