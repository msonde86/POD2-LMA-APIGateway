package com.scb.pod2.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulPreFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPreFilter.class);

	@Override
	public boolean shouldFilter() {
		boolean isFilter = true;
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		if (request.getRequestURL().toString().equals("http://localhost:8084/login-service/api/login/authenticate")) {
			isFilter = false;
		}
		return isFilter;
	}

	@Override
	public Object run() throws ZuulException {

		logger.info("Executing zuul pre filter");
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String authHeader = request.getHeader("authorization");
		String jwtToken = "";
		if (authHeader != null && authHeader.length() > 7) {
			jwtToken = authHeader.substring(7);
		}
		if (authHeader == null || authHeader.trim().equals("") || !authHeader.startsWith("Bearer")
				|| jwtToken.trim().equals("")) {
			logger.error("Zuul filter: Invalid token");
			context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			context.setResponseBody("Access denied. Invalid token");
			context.setSendZuulResponse(false);
		}

		return null;

	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
