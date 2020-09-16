package com.scb.pod2.zuul.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping("/authenticate")
	public String test() {
		return "Hello Login service is down";
	}

	@GetMapping("/loan/data")
	public String secondServiceFallback() {
		return "Login service not loaded Please try after some time.";
	}
}
