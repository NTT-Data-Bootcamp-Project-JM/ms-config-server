package com.nttdata.bank.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Published OpenAPI contract of the config server.
 */
@Configuration
public class OpenApiConfig {

    /**
     * @return contract metadata
     */
    @Bean
    public OpenAPI configServerOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Config server")
                .version("1.0.0")
                .description("Serves the externalized banking configuration. Clients read it through the native profile."));
    }
}
