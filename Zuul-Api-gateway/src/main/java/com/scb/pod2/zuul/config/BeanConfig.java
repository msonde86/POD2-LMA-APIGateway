package com.scb.pod2.zuul.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/loan/data/**")
						.filters(f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")))
						.uri("lb://LOAN-SEARCH-SERVICE").id("loanSearchModule"))

				.route(r -> r.path("/api/login/**")
						.filters(f -> f.hystrix(h -> h.setName("Hystrix").setFallbackUri("forward:/fallback/loginSearch")))
						.uri("lb://LOGIN-SERVICE").id("loginModule"))
				.build();
	}
	/*
	 * @Bean public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) { return
	 * builder.routes() .route(r -> r.path("/loan/data") .filters(f -> f.hystrix(h
	 * -> h.setName("Hystrix").setFallbackUri("forward:/fallback/message")))
	 * .uri("lb://loan-search-service").id("LoansearchModule"))
	 * 
	 * // .route(r -> r.path("/consumer/**") // .filters(f -> f.hystrix(h ->
	 * h.setName("Hystrix").setFallbackUri("forward:/fallback/message"))) //
	 * .uri("lb://SECOND-SERVICE").id("consumerModule")) .build();
	 * 
	 * }
	 */
	/*
	 * @Bean public ServerCodecConfigurer serverCodecConfigurer() { return
	 * ServerCodecConfigurer.create(); }
	 */
}
