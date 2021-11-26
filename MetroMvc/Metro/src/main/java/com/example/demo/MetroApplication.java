package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.nischal")
@EnableJpaRepositories(basePackages = "com.nischal.model.persistence")
@EntityScan(basePackages = "com.nischal.beans")
public class MetroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroApplication.class, args);
	}

}
