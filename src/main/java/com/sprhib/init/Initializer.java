package com.sprhib.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(ctx));

		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		ctx.refresh();
		createDB(ctx.getBean(WebAppConfig.class).dataSource());
	}

	private void createDB (DataSource source)
	{
		Flyway flyway = new Flyway();
		flyway.setDataSource(source);
		flyway.clean();
		flyway.migrate();
	}
	
}
