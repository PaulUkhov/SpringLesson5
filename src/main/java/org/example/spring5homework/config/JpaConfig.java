package org.example.spring5homework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing// Связь с супер классом Auditable автоматически обновляет дату и время
public class JpaConfig {
}

//todo При желание можно создать Аудит с JDBC
// @Configuration
// @EnableJdbcAuditing
// public class JdbcConfig {
// }