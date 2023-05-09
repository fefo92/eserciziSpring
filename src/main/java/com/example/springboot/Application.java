package com.example.springboot;

import java.util.Arrays;

import com.example.springboot.model.Meal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {
	@GetMapping("/hello")
	public String index() {
		return "Hello World!";
	}
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return ResponseEntity.status(200).body("Good Afternoon!");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

	}

}
