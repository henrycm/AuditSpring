package com.auditing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.auditing.backend.service", "com.auditing.security", "com.auditing.view" })
@Import({ PersistenceJPAConfig.class, InitialDataConfig.class, AOPConfig.class })
public class AppConfig {

}
