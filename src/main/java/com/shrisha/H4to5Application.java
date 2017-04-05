package com.shrisha;

import com.shrisha.repository.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = User.class)
public class H4to5Application {

	public static void main(String[] args) {
		SpringApplication.run(H4to5Application.class, args);
	}
}
