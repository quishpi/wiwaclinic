package ec.wiwaclinic.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

import ec.wiwaclinic.vista.ViewScope;

@Configuration
public class ConfigureJSF {//implements ServletContextAware {
	@Bean
	public static CustomScopeConfigurer viewScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		Builder<String, Object> builder = new ImmutableMap.Builder<String, Object>();
		builder.put("viewMyBean", new ViewScope());
		builder.put("especieListaBean", new ViewScope());
		builder.put("empresaNuevoBean", new ViewScope());
		configurer.setScopes(builder.build());
		// configurer.setScopes(new ImmutableMap.Builder<String,
		// Object>().put("viewMyBean", new ViewScope()).build());

		return configurer;
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
				new FacesServlet(), "*.xhtml");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}
/*
	@Override
	public void setServletContext(ServletContext servletContext) {
		// Iniciar el contexto de JSF
		// http://stackoverflow.com/a/25509937/1199132
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
	}
*/
}
