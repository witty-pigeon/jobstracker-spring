package me.piccioni.jobstrackerspring.config;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class FlywayInit{

  
  @Autowired
  @Bean(name="flyway", initMethod = "migrate")
  public Flyway setupFlyway(DataSource dataSource) {
    Flyway flyway = new Flyway();
    flyway.setDataSource(dataSource);
    return flyway;
  }
  
}
