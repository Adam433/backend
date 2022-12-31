package com.renkaen.cat_hospital.utils;


import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * Adam
 * JWT工具类
 */
public class JwtUtil {
    /**
     * @param time  过期时间
     * @param signature 密钥
     */

    private static Long time = 1000*60*60*24*3L;
    private static String signature = "renkaen";

    /**
     * 创建JWT
     * @param username  payload
     * @return
     */
    public static String creatJwt(String username){
        JwtBuilder jwtBuilder = Jwts.builder();
        String JWTToken = jwtBuilder
                //header设置
                .setHeaderParam("typ","JWT")//头参数：type
                .setHeaderParam("alg","HS256")//算法参数：HS256
                //payload设置
                .claim("username",username)
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //设置signature
                .signWith(SignatureAlgorithm.HS256,generateKey())
                .compact()
        ;
        return JWTToken;
    }

    /**
     * 解析 JWTToken
     * @param JWTToken
     * @return
     */
    public static Claims parseJwt(String JWTToken){
        JwtParser jwtParser = Jwts.parser();
        return jwtParser.setSigningKey(generateKey()).parseClaimsJws(JWTToken).getBody();
    }
    //设置密匙
    public static SecretKey generateKey(){
        byte[] encodedKey = Base64.getDecoder().decode(signature);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}