package com.labanta.servidorlocal.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;

@Service
public class JwtService {

    private final SecretKey chaveSecreta = Keys.hmacShaKeyFor(
            "$2a$12$eyKi5thqBp/yg7jCU8PCSeqaYJA2fUE6C2e2HlBQUT8PJ2xEW8KKW".getBytes()
    );
    public String gerarToken(String username) {

        return Jwts.builder()
                .subject(username)
                .signWith(chaveSecreta)
                .compact();
    }
}
