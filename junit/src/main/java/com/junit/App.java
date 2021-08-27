package com.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class App {
	@Test
	public void testSetup() {
		String str = "I am done with Junit setup";
		assertEquals("I am done with Junit setup", str);
	}
}