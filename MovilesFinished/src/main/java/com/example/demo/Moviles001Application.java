package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.AppUserService;

@SpringBootApplication
public class Moviles001Application {
	@Autowired
	AppUserService appUserService;

	public static void main(String[] args) {
		SpringApplication.run(Moviles001Application.class, args);
		
	}

}
