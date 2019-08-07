package com.babydragons.oneride.oneride.config;

import com.babydragons.database.config.PostgresDatabaseConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.babydragons.*")
@Import({PostgresDatabaseConfig.class})
public class OneRideConfig implements WebMvcConfigurer {
}
