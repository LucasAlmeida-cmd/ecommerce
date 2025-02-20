package com.ecommerce.ecommerce.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    public void setPrefix(String prefix) {
        PREFIX = prefix;
    }

    public void setKey(String key) {
        KEY = key;  // A chave é mantida como String
    }

    public void setExpiration(Long expiration) {
        EXPIRATION = expiration;
    }
}
