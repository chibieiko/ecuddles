package com.evil;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bootstraps the application.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@SpringBootApplication
@EnableEmailTools
public class EcuddlesApplication {

	/**
	 * Bootstraps the application.
	 *
	 * @param args	Arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EcuddlesApplication.class, args);
	}
}
