package com.evil;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class EcuddlesApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcuddlesApplication.class, args);
	}
}
