package com.scb.pod2.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.scb.pod2.zuul.filter.ZuulPreFilter;

import lombok.Generated;

@SpringBootApplication
@EnableZuulProxy
@EnableHystrix
public class ZuulApiGatewayApplication {

	@Generated
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
	
	@Bean
	public ZuulPreFilter preFilter() {
		return new ZuulPreFilter();
	}

}
