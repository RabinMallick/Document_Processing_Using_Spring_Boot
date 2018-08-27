package com.ude.sdp;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {  
	
	//Para verificar http://localhost:8080/spring-security-rest/api/v2/api-docs
	//Swagger ui  http://localhost:8080/your-app-root/swagger-ui.html
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();
        
        //Para no mostrar toda la info
        /*
        return new Docket(DocumentationType.SWAGGER_2)          
        .select()                                       
        .apis(RequestHandlerSelectors.basePackage("org.baeldung.web.controller"))
        .paths(PathSelectors.ant("/foos/*"))                     
        .build();*/
    }
    
    @SuppressWarnings("unused")
	private ApiInfo apiInfo() {
        return new ApiInfo(
          "REST API", 
          "Descripcion API.", 
          "API", 
          "Terminos de servicio", 
          new Contact("John", "www.jhon.com", "david.andres.quintans@gmail.com"), 
          "License of API", "API license URL", Collections.emptyList());
   }
}