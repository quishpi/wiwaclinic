package ec.wiwaclinic.config;

import java.util.Collections;

import javax.faces.webapp.FacesServlet;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJSF {// implements ServletContextAware {
	@Bean
	public static CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.setScopes(Collections.<String, Object>singletonMap(FacesViewScope.NAME, new FacesViewScope()));
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
	 * @Bean public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
	 * webServerFactoryCustomizer() { return factory ->
	 * factory.setContextPath("/wiwaclinic"); }
	 * 
	 */
	/*
	 * @Override public void setServletContext(ServletContext servletContext) { //
	 * Iniciar el contexto de JSF // http://stackoverflow.com/a/25509937/1199132
	 * servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration",
	 * Boolean.TRUE.toString());
	 * servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS",
	 * "true"); }
	 */

}
