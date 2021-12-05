package com.lafacondb;

import java.util.ArrayList;
import java.util.HashMap;

import com.lafaconmod.Category;
import com.lafaconmod.Item;

public class InventoryManager {

	private static HashMap<String, Item> inventory;

	public InventoryManager() {
		if (inventory == null)
			inventory = new HashMap<>();
	}

	public void createInventory(ArrayList<ArrayList<String>> data) {
		for (ArrayList<String> row : data) {
			Category category = null;
			if (row.get(0).equalsIgnoreCase("essential")) {
				category = Category.ESSENTIALS;
			}
			if (row.get(0).equalsIgnoreCase("luxury")) {
				category = Category.LUXURY;
			}
			if (row.get(0).equalsIgnoreCase("misc")) {
				category = Category.MISC;
			}
			Item item = new Item(row.get(1), category, Integer.parseInt(row.get(2)), Double.parseDouble(row.get(3)));
			inventory.put(row.get(1), item);
		}
	}

	public void addItem(String name, Item details) {
		inventory.put(name, details);
	}
	
	public Item getItem(String name) {
		return inventory.get(name);
	}

	public void reduceQty(String name, int qty) {
		Item item = inventory.get(name);
		item.setQuantity(item.getQuantity() - qty);
		inventory.put(name, item);
	}

	@Override
	public String toString() {
		return "Inventory [inventory=" + inventory + "]";
	}

}
