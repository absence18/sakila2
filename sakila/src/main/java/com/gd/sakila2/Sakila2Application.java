package com.gd.sakila2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Sakila2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sakila2Application.class, args);
	}

}
