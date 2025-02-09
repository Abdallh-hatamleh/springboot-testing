package com.example.idk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IdkApplication {

//	private static final Logger = LogManager.getLogger(IdkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IdkApplication.class, args);
	}

}
