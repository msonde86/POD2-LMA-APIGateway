package com.scb.pod2.zuul.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * If predicates is not matched, then fallbackURI route it to the specific fall back endpoint 
 * based on the configuration in YML properties and Bean config class file.
 */

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping("/loansearchService")
	public ResponseEntity<String> loansearchFallback() {
		return ResponseEntity.status(HttpStatus.GONE).body("Loan search service is temporarily unavailable");
	}

	@GetMapping("/loginService")
	public ResponseEntity<String> loginsearchFallback() {
		return ResponseEntity.status(HttpStatus.GONE).body("Login service is temporarily unavailable");

	}

}
