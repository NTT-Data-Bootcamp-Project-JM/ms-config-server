package com.nttdata.bank.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Shared settings that every business service used to repeat locally.
 */
class SharedConfigCatalogTest {

    @Test
    void sharedFileHoldsSecurityInfrastructureAndContractSettings() throws Exception {
        List<PropertySource<?>> sources = new YamlPropertySourceLoader()
                .load("application", new ClassPathResource("config/application.yml"));
        PropertySource<?> source = sources.get(0);

        assertEquals("bank-bootcamp-demo-secret-change-me", source.getProperty("bank.security.jwt-secret"));
        assertEquals(120, ((Number) source.getProperty("bank.security.jwt-expiration-minutes")).intValue());
        assertEquals("admin", source.getProperty("bank.security.bootstrap-username"));
        assertEquals("admin123", source.getProperty("bank.security.bootstrap-password"));
        assertEquals("http://localhost:8761/eureka", source.getProperty("eureka.client.service-url.defaultZone"));
        assertEquals("${MONGODB_HOST:localhost}", source.getProperty("spring.data.mongodb.host"));
        assertEquals("${REDIS_HOST:localhost}", source.getProperty("spring.data.redis.host"));
        assertEquals("${KAFKA_BOOTSTRAP_SERVERS:localhost:9092}", source.getProperty("spring.kafka.bootstrap-servers"));
        assertEquals("2s", source.getProperty("resilience4j.timelimiter.instances.customer.timeoutDuration"));
        assertEquals(false, source.getProperty("springdoc.api-docs.enabled"));
        assertEquals("/openapi.yaml", source.getProperty("springdoc.swagger-ui.url"));
        assertNotNull(source.getProperty("bank.checking.maintenance-fee"));
    }
}
