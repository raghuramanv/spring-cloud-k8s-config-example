package io.azu.k8s.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/welcome")
@Slf4j
public class GreetingsController {
	
	@Value("${message:Welcome to Kubernetes from Elsewhere!}")
	private String message;
	
	@GetMapping
	public ResponseEntity<String> greetings() {
		log.info(message);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
