package be.bstorm.tf_java2023_demospringbook.api.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private byte[] secret = "Yabadadooooooooooooooooooooooooooooooooooooooooooooooooo".getBytes(StandardCharsets.UTF_8);

    public int expireAt = 86400; // 1Days

    public SecretKey secretKey = new SecretKeySpec(secret,"HmacSHA384");
}
