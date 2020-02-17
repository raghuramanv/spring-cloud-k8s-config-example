package io.azu.k8s.config.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.azu.k8s.config.GreetingConfiguration;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GreetingsScheduler {
	
	@Autowired
	GreetingConfiguration config;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Scheduled(fixedDelay=5000)
	public void scheduledGreeting() {
		log.info(config.getMessage());
		String url = "http://users-service:8080/users";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		log.info("Via K8s Discovery Client... {} ", responseEntity.getBody());
	}

}
