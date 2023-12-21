package com.rfl.rhredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.rfl.rhredis")
@EnableCaching
public class RhredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhredisApplication.class, args);
	}

}
