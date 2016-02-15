package me.piccioni.jobstrackerspring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebappInitializer implements WebApplicationInitializer{

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.setConfigLocations("me.piccioni.jobstrackerspring.config");
    
    ServletRegistration.Dynamic dispatcher = servletContext
            .addServlet("SpringDispatcher", new DispatcherServlet(applicationContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
    
  }
  
}
