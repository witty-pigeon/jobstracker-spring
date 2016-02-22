package me.piccioni.jobstrackerspring.test.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

/**
 *
 */
@Configuration
public class TestDataSource {

  @Bean(name = "dataSource", destroyMethod = "close")
  @Profile("test")
  public DataSource getDatasource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();

    
    dataSource.setDriverClass("org.hsqldb.jdbcDriver");
    dataSource.setJdbcUrl("jdbc:hsqldb:mem:jobstrackerspring");
    dataSource.setUser("sa");
    dataSource.setPassword("");

    dataSource.setAcquireIncrement(3);
    dataSource.setMaxIdleTime(600);
    dataSource.setMinPoolSize(5);
    dataSource.setMaxPoolSize(20);
    dataSource.setMaxStatements(50);
    dataSource.setIdleConnectionTestPeriod(3000);

    return dataSource;
  }
  
  @Autowired
  @Bean(name = "sessionFactory")
  @Profile("test")
  public SessionFactory getSessionFactory(DataSource dataSource) {
    // Replaces the XML version of LocalSessionFactoryBean
    LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
    builder.scanPackages("me.piccioni.jobstrackerspring.model");
    
    Properties hibProperties = new Properties();
    hibProperties.setProperty("hibernate.hbm2ddl.auto", "create");
    hibProperties.setProperty("hibernate.dialect","org.hibernate.dialect.HSQLDialect");
    hibProperties.setProperty("hibernate.show_sql", "true");
    
    
    builder.addProperties(hibProperties); 
    SessionFactory sessionFactory = builder.buildSessionFactory();
    
    return sessionFactory;
  }
}
