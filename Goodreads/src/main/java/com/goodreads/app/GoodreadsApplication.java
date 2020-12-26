package com.goodreads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class GoodreadsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(GoodreadsApplication.class, args);
	}
	
	
	 @Configuration
	    public class WebConfig implements WebMvcConfigurer {      
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("/**")
	            .addResourceLocations("classpath:/static/","classpath:/images/")
	            .setCachePeriod(0);
	        }
	    }

}
