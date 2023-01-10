package com.renkaen.cat_hospital.filter;


import com.renkaen.cat_hospital.bean.DO.StaffToken;
import com.renkaen.cat_hospital.utils.JwtUtil;
import com.renkaen.cat_hospital.utils.RedisUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        //token = null
        if(StringUtils.isBlank(token)){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String username;
        try {
            Claims claims = JwtUtil.parseJwt(token);
            username = (String) claims.get("username");
        } catch (Exception e) {
            //token解析失败，放行
            filterChain.doFilter(request,response);
            return;
        }
        //从redis中获取用户信息
        String redisKey = "login:" + username;
        StaffToken staffToken =  redisUtil.getCacheObject(redisKey);
        if(Objects.isNull(staffToken)){
            //token解析成功但redis中无数据，放行
            filterChain.doFilter(request,response);
            return;
        }

        //TODO 更改权限时，清空修改权限后影响到的用户的redis
        //根据Token生成权限列表
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String authority : staffToken.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        //UsernamePasswordAuthenticationToken三个参数的构造函数构造已认证token，super.setAuthenticated(true);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(staffToken,null,authorities);
        //在该线程中的已认证信息存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        filterChain.doFilter(request,response);
    }

}
