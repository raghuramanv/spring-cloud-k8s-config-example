package io.azu.k8s.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties(prefix="greeting")
@Configuration
@Data
public class GreetingConfiguration {
	
	private String message = "Hello! Welcome ! Explore more of Kubernetes!";
	

}
