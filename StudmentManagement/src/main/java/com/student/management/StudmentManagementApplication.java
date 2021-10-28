package com.student.management;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.student"})
//@ComponentScan({ "com.controller.*"}) // If our Controller class or Service class is not in the same packages we have //to add packages's name like this...directory(package) with main class
@EnableJpaRepositories("com.student")

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.student"})  // scan JPA entities

public class StudmentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudmentManagementApplication.class, args);
	}

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
