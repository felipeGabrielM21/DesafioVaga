package com.desafioVaga.Dexus.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.desafioVaga.Dexus.repository")
@EntityScan(basePackages = "com.desafioVaga.Dexus.model")
public class DexusApplication {
	public static void main(String[] args) {
		SpringApplication.run(DexusApplication.class, args);
	}
}