package com.erpportal.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.erpportal.infrastructure.repositories")
@EntityScan(basePackages = "com.erpportal.domain.entities")
@EnableTransactionManagement
public class DatabaseConfig {
    // Database configuration is handled by Spring Boot auto-configuration
} 