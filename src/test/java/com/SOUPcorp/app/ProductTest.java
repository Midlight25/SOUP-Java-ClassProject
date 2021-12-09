package com.SOUPcorp.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit Tests for Product Class.
 */
public class ProductTest {
	private Product sampleProduct = new Product("Sample", 10.0);

	/**
	 * Object is instantiated correctly.
	 */
	@Test
	public void createItem() {
		assertTrue("Product Class was not able to be instantiated.", sampleProduct instanceof Product);
	}

	/**
	 * Object was instantiated with the correct fields, and those fields persisted.
	 */
	@Test
	public void checkGetters() {
		assertTrue("Product name is not \"Sample\".", sampleProduct.getName().equals("Sample"));
		assertTrue("Product price is not $10.", sampleProduct.getPrice() == 10.0);
	}

	@Test
	public void check_toString() {
		assertTrue("Product toString method did not produce the expected result: (Ex: \"Sample 10.0\")", sampleProduct.toString().equals("Sample 10.0"));
	}
}
