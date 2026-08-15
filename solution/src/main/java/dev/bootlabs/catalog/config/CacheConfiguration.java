package dev.bootlabs.catalog.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.time.Duration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CacheConfiguration {
    @Bean
    CacheManager cacheManager() {
        var manager = new CaffeineCacheManager("books");
        manager.setCaffeine(Caffeine.newBuilder().maximumSize(500).expireAfterWrite(Duration.ofMinutes(10)));
        return manager;
    }
}
