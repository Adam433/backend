package com.renkaen.cat_hospital.config;

import com.renkaen.cat_hospital.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity  // 添加 security 过滤器
@EnableGlobalMethodSecurity(prePostEnabled = true)    // 启用方法级别的权限认证
public class SecurityConfig {
    @Autowired
    public UserDetailsService userDetailsService;
    @Autowired//jwt 校验过滤器，从 http 头部 token 字段读取 token 并校验
    private JwtTokenFilter jwtTokenFilter;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private LogoutHandler logoutHandler;

    @Bean//密码加密方式
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http//基本设置
                //允许跨域访问
                .cors()
                .and()
                //前后端分离的设置，关闭csrf，如果是前后端不分离的项目，认证信息在cookies，关闭后不安全。
                .csrf().disable()
                //配置取消session管理,又Jwt来获取用户状态,否则即使token无效,也会有session信息,依旧判断用户为登录状态
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                //这里表示"/any"和"/ignore"不需要权限校验
                .antMatchers().permitAll()
                .anyRequest().authenticated();
                // 这里表示任何请求都需要校验认证(上面配置的放行)


        http.formLogin()//表单认证方式，不是采用接口访问
                //前端表单的action地址
                .loginProcessingUrl("/login")
                //允许所有人访问登陆链接
                .permitAll()
                //登陆成功
                .successHandler(authenticationSuccessHandler)
                //登陆失败
                .failureHandler(authenticationFailureHandler).and()
                .logout()
                .logoutUrl("/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(logoutSuccessHandler);

        http.exceptionHandling()//异常处理
                //未登录的拦截处理，自己写实现类
                .authenticationEntryPoint(authenticationEntryPoint)
                //未获得授权的处理，自己写实现类
                .accessDeniedHandler(accessDeniedHandler)
        ;
        //自定义过滤器
        http
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtTokenFilter, LogoutFilter.class);
        return http.build();
    }
}
