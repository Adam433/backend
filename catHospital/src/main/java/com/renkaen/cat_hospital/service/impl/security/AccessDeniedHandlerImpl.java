package com.renkaen.cat_hospital.service.impl.security;

import com.alibaba.fastjson.JSON;
import com.renkaen.cat_hospital.domain.ResponseResult;
import com.renkaen.cat_hospital.utils.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//访问接口没有权限时,调用该方法
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //将要返回前端的JSON创建出来
        ResponseResult responseResult = new ResponseResult<>(HttpStatus.FORBIDDEN.value(), "无此权限");
        //将这个JSON转化为JSON字符串
        String responseResultString = JSON.toJSONString(responseResult);
        //将JSON字符串写入response中
        WebUtil.renderString(response,responseResultString);
    }
}
