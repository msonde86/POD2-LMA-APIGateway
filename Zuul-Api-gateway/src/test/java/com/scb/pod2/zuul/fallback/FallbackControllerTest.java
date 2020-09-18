package com.scb.pod2.zuul.fallback;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FallbackControllerTest {

	private FallbackController fallBack = new FallbackController();
	
	@Test
	public void testTheTestGet() throws Exception {

	
		Assert.assertEquals("Hello Loan search service is down", fallBack.test());
	}
	
	@Test
	public void testLoginSearch() throws Exception {

		
		Assert.assertEquals("Hello Login service is down", fallBack.loginSearch());
	}
}
