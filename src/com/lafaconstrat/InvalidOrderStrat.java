package com.lafaconstrat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lafaconmod.Item;

public class InvalidOrderStrat implements CheckoutStrat {

	@Override
	public ArrayList<String> checkout(List<Item> items) throws IOException {
		ArrayList<String> output = new ArrayList<>();
		output.add("List of items with incorrect quantities");
		for (Item item : items) {
			output.add("Name: " + item.getName() + ", Quantity: " + item.getQuantity());
		}
		return output;
	}

}
