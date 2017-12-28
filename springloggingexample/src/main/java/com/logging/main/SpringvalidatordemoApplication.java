package com.logging.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.logging"})
public class SpringvalidatordemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringvalidatordemoApplication.class, args);
	}
}
