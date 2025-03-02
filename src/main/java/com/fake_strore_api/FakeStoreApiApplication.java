package com.fake_strore_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FakeStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeStoreApiApplication.class, args);
		System.out.println("App is running!!!!");
	}

}
