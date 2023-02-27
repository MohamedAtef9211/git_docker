package com.example.githubcli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GithubCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubCliApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello";
	}


}
