package com.te.sbs.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SampleTestJava {

	@Test
	public void sampleTestMethod() {

		int a = 5;
		int b = 6;

		int c = a + b;
		assertEquals(5, c);

	}
}