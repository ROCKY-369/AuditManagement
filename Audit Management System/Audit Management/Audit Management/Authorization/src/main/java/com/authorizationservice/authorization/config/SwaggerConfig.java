package com.authorizationservice.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 @Slf4j
public class SwaggerConfig { 
	/**
	 * This method used to build a document where we can provide all the datails of the microservice.
	 * @return docket
	 */

	@Bean
	public Docket api() { 

		Docket docket= new Docket(DocumentationType.SWAGGER_2)  
				.select()                                  
				.apis(RequestHandlerSelectors.basePackage("com.authorizationservice.authorization"))              
				.paths(PathSelectors.any())                          
				.build().apiInfo(apiDetails()); 
		log.debug("Docket{}:", docket);
		return docket;
	}
	/**
	 * This method used to give the info about the documentation like title, contact details and version;
	 * @return apiinfo
	 */
	private ApiInfo apiDetails() {
		ApiInfo apiInfo= new ApiInfoBuilder()
				.title("AuthorizationMicroservice Documentation")
				.description("Gets the login details and checks the login details if yes it will generate a JWT token which we can use to validate the user.")
				.termsOfServiceUrl("Help")
				.license("Audit Management System 1.0")
				.contact(new Contact("ACB XYZ","cognizant.com","abc@cognizant.com"))
				.version("1.0")		
				.build();
		log.debug("API Info{}:", apiInfo);
		return apiInfo;
	}
}
