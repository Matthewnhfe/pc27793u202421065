package com.medisupply.platform.u202421065;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class u202421065Application {

	public static void main(String[] args) {
		SpringApplication.run(u202421065Application.class, args);
	}

}
