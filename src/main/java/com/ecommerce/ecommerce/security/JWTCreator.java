package com.ecommerce.ecommerce.security;

import io.jsonwebtoken.*;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class JWTCreator {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix, String key, JWTObject jwtObject) {
        // Codifica a chave secreta em Base64
        String base64Key = Base64.getEncoder().encodeToString(key.getBytes());

        String token = Jwts.builder()
                .setSubject(jwtObject.getSubject())
                .setIssuedAt(jwtObject.getIssuedAt())
                .setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles()))
                .signWith(SignatureAlgorithm.HS512, base64Key) // Usa a chave codificada em Base64
                .compact();

        return prefix + " " + token;
    }
    public static JWTObject create(String token, String prefix, String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        // Codifica a chave secreta em Base64
        String base64Key = Base64.getEncoder().encodeToString(key.getBytes());

        token = token.replace(prefix, "");
        Claims claims = Jwts.parser()
                .setSigningKey(base64Key) // Usa a chave codificada em Base64
                .parseClaimsJws(token)
                .getBody();

        JWTObject object = new JWTObject();
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        object.setRoles((List) claims.get(ROLES_AUTHORITIES));

        return object;
    }

    private static List<String> checkRoles(List<String> roles) {
        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_",""))).collect(Collectors.toList());
    }


}
