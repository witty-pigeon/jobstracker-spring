package me.piccioni.jobstrackerspring.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
  "me.piccioni.jobstrackerspring.dao",
  "me.piccioni.jobstrackerspring.service",
  "me.piccioni.jobstrackerspring.model",
})
public class TestConfig {
  
}
