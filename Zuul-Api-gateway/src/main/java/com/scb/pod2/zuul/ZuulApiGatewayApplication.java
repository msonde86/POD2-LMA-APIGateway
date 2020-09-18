package com.scb.pod2.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import lombok.Generated;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
public class ZuulApiGatewayApplication {

	@Generated
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}

}
