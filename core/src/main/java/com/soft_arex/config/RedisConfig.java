package com.soft_arex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() throws URISyntaxException {
        String redisUrl = System.getenv("REDIS_URL");
        if (redisUrl == null || redisUrl.isEmpty()) {
            redisUrl = "redis://localhost:6379";
        }

        URI redisUri = new URI(redisUrl);

        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisUri.getHost());
        config.setPort(redisUri.getPort());
        if (redisUri.getUserInfo() != null) {
            config.setPassword(RedisPassword.of(redisUri.getUserInfo().split(":")[1]));
        }

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(java.time.Duration.ofSeconds(60))
                .build();

        return new LettuceConnectionFactory(config, clientConfig);
    }
}