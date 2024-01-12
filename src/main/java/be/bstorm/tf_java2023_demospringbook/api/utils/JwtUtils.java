package be.bstorm.tf_java2023_demospringbook.api.utils;

import be.bstorm.tf_java2023_demospringbook.api.configs.JwtConfig;
import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final JwtConfig config;
    private final JwtBuilder builder;
    private final JwtParser parser;

    public JwtUtils(JwtConfig config) {
        this.config = config;
        this.builder = Jwts.builder().signWith(config.secretKey);
        this.parser = Jwts.parserBuilder().setSigningKey(config.secretKey).build();
    }

    public String generateToken(User user){
        return builder
                .claim("id",user.getId())
                .claim("email",user.getEmail())
                .claim("role",user.getRole().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.expireAt * 1000L))
                .compact();
    }

    public Claims getClaims(String token){
        return parser.parseClaimsJws(token).getBody();
    }

    public Long getId(String token){
        return getClaims(token).get("id", Long.class);
    }

    public String getEmail(String token){
        return getClaims(token).get("email", String.class);
    }

    public String getRole(String token){
        return getClaims(token).get("role", String.class);
    }

    public boolean isValid(String token){

        Claims claims = getClaims(token);
        Date now = new Date();
        return getRole(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}
