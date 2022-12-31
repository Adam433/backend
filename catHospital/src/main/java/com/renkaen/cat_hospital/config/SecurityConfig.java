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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity  // 添加 security 过滤器
@EnableGlobalMethodSecurity(prePostEnabled = true)	// 启用方法级别的权限认证
public class SecurityConfig{
    @Autowired
    public UserDetailsService userDetailsService;

    @Bean//密码加密方式
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    //权限不足错误信息处理，包含认证错误与鉴权错误处理
//    @Autowired
//    private JwtAuthError jwtAuthError;

    //jwt 校验过滤器，从 http 头部 token 字段读取 token 并校验
    @Autowired
    private JwtTokenFilter jwtTokenFilter;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //允许跨域访问
                .cors()
                .and()
                //前后端分离的设置，关闭csrf，如果是前后端不分离的项目，认证信息在cookies，关闭后不安全。
                .csrf().disable()
                //配置取消session管理,又Jwt来获取用户状态,否则即使token无效,也会有session信息,依旧判断用户为登录状态
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                //设置 jwtAuthError 处理认证失败、鉴权失败
//                .exceptionHandling().authenticationEntryPoint(jwtAuthError).accessDeniedHandler(jwtAuthError)
                .and()
                .authorizeRequests()
                //登陆接口允许匿名访问
                .antMatchers("/staff/login").anonymous()
                .anyRequest()
//                // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
//                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
                .authenticated()
                .and()
                .exceptionHandling()
                //认证失败处理器，自己写实现类
                .authenticationEntryPoint(authenticationEntryPoint)
                //未获得授权处理器，自己写实现类
                .accessDeniedHandler(accessDeniedHandler)
                ;
        http.addFilterBefore(jwtTokenFilter,UsernamePasswordAuthenticationFilter.class);
//        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
