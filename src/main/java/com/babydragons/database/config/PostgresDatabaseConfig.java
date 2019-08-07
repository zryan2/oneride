package com.babydragons.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.babydragons.database.*")
@EnableTransactionManagement
public class PostgresDatabaseConfig {
}
