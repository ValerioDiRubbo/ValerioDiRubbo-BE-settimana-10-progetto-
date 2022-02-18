package it.progettofilm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")

@EnableWebMvc
@Configuration
@ComponentScan({"it"})

public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
		super.addResourceHandlers(registry);
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**") // Doppio asterisco prende anche le cartelle, non solo i file. ATTENZIONE alle barre finali!
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	
}
