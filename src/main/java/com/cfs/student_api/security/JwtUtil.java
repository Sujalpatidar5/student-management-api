package com.cfs.student_api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());   //Key object bnaya JWT library ko String ni chahiye, usko Key object chahiye

    public String generateToken (String username) {      //token generate method - method ka kaam : username lega -> jwt token bnayga -> token return krega
        return Jwts.builder()        //ye token bnana start krta h
                .setSubject(username)      //token kis user ka h
                .setIssuedAt(new Date())      //token kab generate hua
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  //1 hour baad expiry
                .signWith(key)    //jwt token secret key se sign krta h -> mtlb server ek digital signature add krta h token me
                .compact();   //ye final token generate krta h
    }

    public String extractUsername (String token) {
        Claims claims = Jwts.parserBuilder()      //jwt parser library start krta h
                .setSigningKey(key)               //token verify krne k liye same secret key use hoti h
                .build()                 //parser ready hogya
                .parseClaimsJws(token)       //jwt token read krega
                .getBody();                //payload mil gya

        return claims.getSubject();        //username return
    }
}

