package com.nttdata.bank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Serves the externalized configuration required by the bootcamp.
 * Business numbers (fees, movement limits, JWT) live here, not in Java code.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * Starts the native config server.
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
