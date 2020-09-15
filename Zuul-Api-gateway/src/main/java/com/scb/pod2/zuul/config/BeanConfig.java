package com.scb.pod2.zuul.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;

@Configuration
public class BeanConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/loansearch/**")
						.filters(f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")))
						.uri("lb://LOAN-SEARCH-SERVICE").id("LoansearchModule"))

//				.route(r -> r.path("/consumer/**")
//						.filters(f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")))
//						.uri("lb://SECOND-SERVICE").id("consumerModule"))
				.build();

	}

	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
		return ServerCodecConfigurer.create();
	}
}
