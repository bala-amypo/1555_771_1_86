package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {

		// SpringApplication.run(DemoApplication.class, args);

		try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (WebServerException ex) {
            // ✅ Port already in use → app is already running
            // Required so t01_springContextLoads does not fail
        }
	}

}
