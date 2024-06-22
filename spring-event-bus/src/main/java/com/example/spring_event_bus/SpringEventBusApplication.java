package com.example.spring_event_bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringEventBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventBusApplication.class, args);
	}

}
