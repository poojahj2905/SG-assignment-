package com.example.demo.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerImpl {
	 @Bean
	    public Docket createAPI() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
	                .paths(regex("/api.*")).build().pathMapping("/")
	                .apiInfo(apiData()).useDefaultResponseMessages(false);
	    }
	    
	    @Bean
	    ApiInfo apiData() {
	        final ApiInfoBuilder builder = new ApiInfoBuilder();
	        builder.title("Employee Service API").version("1.0").license("(C) Pooja")
	                .description("List of all endpoints used in Employee API");
	        return builder.build();
	    }



}
