package com.example.BhatiaIndustrialHozeInternship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class BhatiaIndustrialHozeInternshipApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BhatiaIndustrialHozeInternshipApplication.class, args);
	}

}
