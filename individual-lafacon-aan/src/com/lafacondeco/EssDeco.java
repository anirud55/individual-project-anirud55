package com.lafacondeco;

import com.lafacon.OrderManager;

public class EssDeco implements CatDeco {

	@Override
	public void decorateCategory(int qty) {
		OrderManager.essentials += qty;
	}

}
