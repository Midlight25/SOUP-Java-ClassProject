package com.SOUPcorp.app;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class ShoppingCartTest {
	private ShoppingCart sampleCart = new ShoppingCart();

	/**
	 * Checks for correct instantiation of sampleCart object
	 */
	@Test
	public void checkInstantiation() {
		assertTrue("Shopping Cart was not instantiated.", sampleCart instanceof ShoppingCart);
	}

	/**
	 * Adds items to the shopping cart
	 */
	@Test
	public void addItems() {
		Product sample = new Product("Sample", 10.0);
		sampleCart.addCartItem(sample, 10);
		Map<Item, Integer> items = sampleCart.getItems();

		assertTrue(items.get(sample) == 10);
	}

	/**
	 * Check on price finding method
	 */
	@Test
	public void check_findTotalPrice() {
		Product sample = new Product("Sample", 10.0);

		sampleCart.addCartItem(sample, 10);
		assertTrue(sampleCart.findTotalPrice() == 100);
	}

}
