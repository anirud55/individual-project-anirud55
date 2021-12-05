package com.lafacondeco;

import com.lafacon.OrderManager;

public class MiscDeco implements CatDeco {

	@Override
	public void decorateCategory(int qty) {
		OrderManager.misc += qty;
	}

}
