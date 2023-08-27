package com.web.prog4td;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Prog4td {
	public static void main(String[] args) {
		SpringApplication.run(prog4td.class, args);
	}

}
