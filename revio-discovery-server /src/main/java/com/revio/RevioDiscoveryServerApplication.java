package com.revio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RevioDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevioDiscoveryServerApplication.class, args);
	}

}
