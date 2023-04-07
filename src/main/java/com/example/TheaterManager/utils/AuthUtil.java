package com.example.TheaterManager.utils;

import com.example.TheaterManager.service.JwtService;
import com.example.TheaterManager.service.impl.JwtServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthUtil {

    private static final JwtService jwtService = new JwtServiceImpl();
    public static String validateToken(String token){
        String extractUsername;
        try {
            extractUsername = jwtService.extractUsername(token);
        }catch (MalformedJwtException | ExpiredJwtException e){
            return null;
        }
        return extractUsername;
    }
}
