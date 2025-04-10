package ru.burdukov.gui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import ru.burdukov.spring.hibernate.config.DbConfig;

@Configuration
@PropertySource("jdbc.properties")
@Import(DbConfig.class)
@ComponentScan(basePackages = "ru.burdukov")
public class SpringConfig {

}