package com.Token.JWT_Token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JwtTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenApplication.class, args);
	}

}
