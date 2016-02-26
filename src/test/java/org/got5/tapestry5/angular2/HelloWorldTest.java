package org.got5.tapestry5.angular2;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

public class HelloWorldTest extends SeleniumTestCase {


	@Test
    public void testHelloword(){

    	open("/HelloWorld");
    	
		assertTrue(isElementPresent("//div/hello-world/div"));

    }

}
