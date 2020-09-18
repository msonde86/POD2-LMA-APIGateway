package com.scb.pod2.zuul.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Here we use RouteLocator Builder class in order to route the service to the appropriate Microservices
 * Route – the primary API of the gateway. It is defined by a given identification (ID), a destination (URI) and set of predicates and filters
 * Predicate – a Java 8's Predicate – which is used for matching HTTP requests using headers, methods or parameters
 * Filter – a standard Spring's WebFilter 
 *  
 * 
 */


@Configuration
public class BeanConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/loan/data/**").filters(
						f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/loansearchService")))
						.uri("lb://LOAN-SEARCH-SERVICE").id("loanSearchModule"))

				.route(r -> r.path("/api/login/**").filters(
						f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/loginService")))
						.uri("lb://LOGIN-SERVICE").id("loginModule"))
				.build();
	}

}
