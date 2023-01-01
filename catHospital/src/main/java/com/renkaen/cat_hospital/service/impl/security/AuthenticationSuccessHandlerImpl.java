package com.renkaen.cat_hospital.service.impl.security;

import com.alibaba.fastjson.JSON;
import com.renkaen.cat_hospital.bean.PO.StaffToken;
import com.renkaen.cat_hospital.domain.ResponseResult;
import com.renkaen.cat_hospital.utils.JwtUtil;
import com.renkaen.cat_hospital.utils.RedisUtil;
import com.renkaen.cat_hospital.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

//认证成功后调用
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //JWT及权限处理
        User user = (User) authentication.getPrincipal();
        StaffToken staffToken = new StaffToken(user);
        //将用户名和密码加密到jwt中生成tokenauthentication.getPrincipal();
        String jwt = JwtUtil.creatJwt(staffToken.getUsername());
        //userDetails存入redis，
        redisUtil.setCacheObject("login:"+staffToken.getUsername(),staffToken);
        //jwt中生成的token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);

        //将要返回前端的JSON创建出来
        ResponseResult responseResult = new ResponseResult(HttpStatus.OK.value(), "登陆成功",map);
        //将这个JSON转化为JSON字符串
        String responseResultString = JSON.toJSONString(responseResult);
        //将JSON字符串写入response中
        WebUtil.renderString(response,responseResultString);
    }
}
