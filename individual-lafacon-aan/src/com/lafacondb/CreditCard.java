package com.lafacondb;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

	static List<String> creditCards;

	public CreditCard() {
		creditCards = new ArrayList<>();
	}

	public void createCreditCardDb(ArrayList<ArrayList<String>> data) {
		for (ArrayList<String> row : data) {
			addCard(row.get(0));
		}
	}

	public boolean isPresent(String cardNumber) {
		return creditCards.contains(cardNumber);
	}

	public void addCard(String cardNumber) {
		creditCards.add(cardNumber);
	}

	@Override
	public String toString() {
		return "CreditCardDb [creditCards=" + creditCards + "]";
	}

}
