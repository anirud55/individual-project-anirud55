package com.lafacon;

import java.io.IOException;

import com.lafacondb.CreditCard;
import com.lafacondb.InventoryManager;
import com.lafaconio.ParseInput;

public class Application {

	static InventoryManager inventoryManager;
	static CreditCard creditCardDb;
	static OrderManager orderManager;

	public static void main(String[] args) throws IOException {

		String inventoryFile = "resources/dataset.csv";
		String creditCardFile = "resources/CreditCards.csv";
		String inputFile = "resources/input1.csv";

		if (args.length > 0) {
			inventoryFile = args[0];
			creditCardFile = args[1];
			inputFile = args[2];
		}

		initInventory(inventoryFile);
		initCreditCardDb(creditCardFile);
		initOrder(inputFile);
		start();

	}

	private static void initInventory(String inventoryFile) {
		inventoryManager = new InventoryManager();
		inventoryManager.createInventory(ParseInput.parseCsvFile(inventoryFile));
	}

	private static void initCreditCardDb(String creditCardInputFile) {
		creditCardDb = new CreditCard();
		creditCardDb.createCreditCardDb(ParseInput.parseCsvFile(creditCardInputFile));
	}

	private static void initOrder(String inputFile) {
		orderManager = new OrderManager();
		orderManager.createOrder(ParseInput.parseCsvFile(inputFile));
	}

	private static void start() throws IOException {
		orderManager.processOrder();
	}

}
