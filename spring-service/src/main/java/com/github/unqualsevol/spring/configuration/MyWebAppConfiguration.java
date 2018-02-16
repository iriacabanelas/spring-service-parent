package com.github.unqualsevol.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by agimenez on 19/09/17.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.github.unqualsevol.spring")
public class MyWebAppConfiguration {
}
