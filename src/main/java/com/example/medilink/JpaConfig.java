package com.example.medilink;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.medilink")
public class JpaConfig {
    // дополнительные настройки JPA
}

