package com.lafacondeco;

import com.lafacon.OrderManager;

public class LuxDeco implements CatDeco {

	@Override
	public void decorateCategory(int qty) {
		OrderManager.luxury += qty;
	}

}
