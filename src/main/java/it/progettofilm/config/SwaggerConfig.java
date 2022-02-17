package it.progettofilm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value="progettofilm", tags="Gestione lista film.")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	private ApiInfo apiInfo() {
		return  new ApiInfoBuilder()
				.title("Progetto Film")
				.description("Gestione film e registi.")
				.version("1.0.0")
				.license("apache license 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Valerio", "Di Rubbo" , "dirubbovalerio@gmail.com"))
				.build();
	}
	
	// Generatore di documentazioni.
	@Bean
	public Docket api() {
		
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(apiInfo());
		
	}
}
