package com.lafacon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lafacondb.CreditCard;
import com.lafacondb.InventoryManager;
import com.lafacondeco.CatDeco;
import com.lafacondeco.EssDeco;
import com.lafacondeco.LuxDeco;
import com.lafacondeco.MiscDeco;
import com.lafaconio.GenOP;
import com.lafaconmod.Category;
import com.lafaconmod.Item;
import com.lafaconstrat.CheckoutStrat;
import com.lafaconstrat.InvalidOrderStrat;
import com.lafaconstrat.ValidOrderStrat;

public class OrderManager {

	List<Item> validItems;
	List<Item> invalidItems;
	List<Item> checkOutItems;
	String cardNumber;

	public static int essentials = 0;
	public static int luxury = 0;
	public static int misc = 0;

	InventoryManager inventoryManager;
	CheckoutStrat checkoutStrat;

	public OrderManager() {
		this.inventoryManager = new InventoryManager();
		this.validItems = new ArrayList<>();
		this.invalidItems = new ArrayList<>();
	}

	public void createOrder(ArrayList<ArrayList<String>> data) {
		CreditCard ccDb = new CreditCard();
		for (ArrayList<String> row : data) {
			Item item = new Item(row.get(0), inventoryManager.getItem(row.get(0)).getCategory(),
					Integer.parseInt(row.get(1)));
			addToOrder(item);
			if (!ccDb.isPresent(row.get(2)))
				ccDb.addCard(row.get(2));
		}

	}

	public void addToOrder(Item item) {
		if (validateOrder(item)) {
			this.inventoryManager.reduceQty(item.getName(), item.getQuantity());
			validItems.add(item);
		} else
			invalidItems.add(item);
	}

	public void wrapCategory(CatDeco decorator, int qty) {
		decorator.decorateCategory(qty);
	}

	public boolean validateOrder(Item item) {
		if (item.getQuantity() > inventoryManager.getItem(item.getName()).getQuantity())
			return false;

		switch (item.getCategory()) {
		case ESSENTIALS:
			if (essentials + item.getQuantity() > Category.ESSENTIALS.maxCount)
				return false;
			else
				wrapCategory(new EssDeco(), item.getQuantity());
			break;
		case LUXURY:
			if (luxury + item.getQuantity() > Category.LUXURY.maxCount)
				return false;
			else
				wrapCategory(new LuxDeco(), item.getQuantity());
			break;
		case MISC:
			if (misc + item.getQuantity() > Category.MISC.maxCount)
				return false;
			else
				wrapCategory(new MiscDeco(), item.getQuantity());
			break;
		}
		return true;
	}

	public void processOrder() throws IOException {
		if (invalidItems.size() > 0) {
			checkoutStrat = new InvalidOrderStrat();
			this.checkOutItems = invalidItems;
		} else {
			checkoutStrat = new ValidOrderStrat();
			this.checkOutItems = validItems;
		}
		checkout(checkoutStrat);

	}

	public void checkout(CheckoutStrat strategy) throws IOException {
		ArrayList<String> output = strategy.checkout(checkOutItems);
		GenOP.writeToFile("resources/output.txt", output);
	}

}
