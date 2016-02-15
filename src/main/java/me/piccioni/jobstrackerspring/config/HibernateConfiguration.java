package me.piccioni.jobstrackerspring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@PropertySource(value = "classpath:config/hibernate-setup.properties")
public class HibernateConfiguration {

  @Autowired
  private Environment env;
  
  @Bean(name = "dataSource", destroyMethod = "close")
  public DataSource getMysqlDataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    
    dataSource.setDriverClass(env.getProperty("datasource.driver"));
    dataSource.setJdbcUrl(env.getProperty("datasource.jdbcurl"));
    dataSource.setUser(env.getProperty("datasource.username"));
    dataSource.setPassword(env.getProperty("datasource.password"));
    
    
		dataSource.setAcquireIncrement(3);
		dataSource.setMaxIdleTime(600);
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(20);
    dataSource.setMaxStatements(50);
    dataSource.setIdleConnectionTestPeriod(3000);
    
    return dataSource;
  }
  
  /*
  Return Session Factory for Hibernate
  */
  @Autowired
  @Bean(name = "sessionFactory")
  @DependsOn("flyway")
  public SessionFactory getSessionFactory(DataSource dataSource) {
    // Replaces the XML version of LocalSessionFactoryBean
    LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
    builder.scanPackages("me.piccioni.jobstrackerspring.model");
    // setProperties() overrides the defaults. Better to keep them
    builder.addProperties(getHibernateProperties()); 
    SessionFactory sessionFactory = builder.buildSessionFactory();
    
    return sessionFactory;
  }
  
  /**
   * Returns Hibernate Properties to be used with the SessionFactory
   * @return Properties to be used by Hibernate SessionFactory
   */
  public Properties getHibernateProperties() {
    Properties hibProperties = new Properties();
    String hibHbm2ddl = "hibernate.hbm2ddl.auto";
    String hibDialect = "hibernate.dialect";
    String hibShowSql = "hibernate.show_sql";
		hibProperties.put(hibHbm2ddl, env.getProperty(hibHbm2ddl));
    hibProperties.put(hibDialect, env.getProperty(hibDialect));
		hibProperties.put(hibShowSql, env.getProperty(hibShowSql));
    
    return hibProperties;
  }
  
  
  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager (SessionFactory sessionFactory) {
    return new HibernateTransactionManager(sessionFactory);

  }
}
