package com.scb.pod2.zuul.config;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return (RouteLocator) builder.routes()
				.route(r -> r.path("/loan/**")
						.filters(f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")))
						.uri("http://localhost:8082/").id("LoansearchModule"))

//				.route(r -> r.path("/consumer/**")
//						.filters(f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")))
//						.uri("lb://SECOND-SERVICE").id("consumerModule"))
				.build();

	}
}
