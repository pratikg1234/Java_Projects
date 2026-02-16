//package com.boot.jobboardlite.rest.security;
//
//import java.util.Date;
//
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;

//@Component
//public class JwtUtil {
//
//    private final String secret = "a_long_secure_base64_key_of_at_least_32_characters";
//    private final long expirationMs = 86400000;
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//            .setSubject(username)
//            .setIssuedAt(new Date())
//            .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//            .signWith(Keys.hmacShaKeyFor(secret.getBytes()), io.jsonwebtoken.SignatureAlgorithm.HS256)
//            .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//            .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
//            .build()
//            .parseClaimsJws(token)
//            .getBody()
//            .getSubject();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            extractUsername(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}


package com.boot.jobboardlite.rest.security;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final String secret = "bXlzZWNyZXRrZXltdXN0YmUzMmJ5dGVzbG9uZ2VuYWZl"; // this is Base64 encoded (must be ≥ 32 bytes after decoding)

    private final SecretKey secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));

    private final long jwtExpirationMs = 80000; // 1 day

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            return false;
//        }
//    }
    
    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            Claims claims = Jwts.parserBuilder()
                                .setSigningKey(secretKey)
                                .build()
                                .parseClaimsJws(token)
                                .getBody();
            return claims.getSubject().equals(userDetails.getUsername());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

}
