package com.lafaconstrat;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.lafacondb.InventoryManager;
import com.lafaconmod.Item;

public class ValidOrderStrat implements CheckoutStrat {

	InventoryManager inventoryManager = new InventoryManager();

	@Override
	public ArrayList<String> checkout(List<Item> items) throws IOException {
		ArrayList<String> output = new ArrayList<>();
		double amt = 0;
		for (Item item : items) {
			amt += item.getQuantity() * inventoryManager.getItem(item.getName()).getPrice();
		}
		BigDecimal amount = new BigDecimal(amt).setScale(2, RoundingMode.HALF_EVEN);
		output.add("Total Amount paid: $" + amount);
		return output;
	}

}
