package com.zhaoyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootLoadbalanceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoadbalanceClientApplication.class, args);
	}
}
