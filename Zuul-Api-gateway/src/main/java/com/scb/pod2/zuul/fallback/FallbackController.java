package com.scb.pod2.zuul.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping("/message")
	public String test() {
		return "Hello Loan search service is down";
	}

	@GetMapping("/loginSearch")
	public String loginSearch() {
		return "Hello Login service is down";
	}
	
}
