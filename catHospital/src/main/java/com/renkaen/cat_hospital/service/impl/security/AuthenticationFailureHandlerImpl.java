package com.renkaen.cat_hospital.service.impl.security;

import com.alibaba.fastjson.JSON;
import com.renkaen.cat_hospital.domain.ResponseResult;
import com.renkaen.cat_hospital.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//登陆失败后该方法被调用
@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //将要返回前端的JSON创建出来
        ResponseResult responseResult = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误");
        //将这个JSON转化为JSON字符串
        String responseResultString = JSON.toJSONString(responseResult);
        //将JSON字符串写入response中
        WebUtil.renderString(response,responseResultString);
    }
}
