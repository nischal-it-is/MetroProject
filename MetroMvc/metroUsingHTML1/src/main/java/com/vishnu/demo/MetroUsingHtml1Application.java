package com.vishnu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.vishnu")
@EntityScan(basePackages = "com.vishnu.beans")
@EnableJpaRepositories(basePackages = "com.vishnu.model.persistence")
public class MetroUsingHtml1Application {

	public static void main(String[] args) {
		SpringApplication.run(MetroUsingHtml1Application.class, args);
	}

}
