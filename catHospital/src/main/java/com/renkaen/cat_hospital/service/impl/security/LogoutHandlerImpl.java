package com.renkaen.cat_hospital.service.impl.security;

import com.renkaen.cat_hospital.bean.PO.StaffToken;
import com.renkaen.cat_hospital.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//logout之前
@Component
public class LogoutHandlerImpl implements LogoutHandler {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println(authentication);
        StaffToken staffToken = (StaffToken) authentication.getPrincipal();
        redisUtil.deleteObject("login:"+staffToken.getUsername());
    }
}
