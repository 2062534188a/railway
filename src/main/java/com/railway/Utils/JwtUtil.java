package com.railway.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    /**
     * 构建jwt令牌
     * @param map 载荷
     * @return jwt令牌
     */
    public static String createJwt(HashMap<String, Object> map){
        //载荷加入过期时间
        map.put("expirationTime",new Date(System.currentTimeMillis()+1000*3600*12));
        return Jwts.builder().
                setClaims(map).
                signWith(SignatureAlgorithm.HS256,"secretKey").
                setExpiration(new Date(System.currentTimeMillis()+1000*3600*12)).
                compact();
    }

    /**
     * 解析jwt
     * @param jwt jwt令牌
     * @return Claims对象
     */
    public static Claims parser(String jwt){
        if (jwt==null){
            return null;
        }
        //返回jwt解析后的Claims对象
        return Jwts.parser().
                setSigningKey("secretKey").
                parseClaimsJws(jwt).
                getBody();
    }



}
