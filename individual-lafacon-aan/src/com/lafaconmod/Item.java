package com.lafaconmod;

import com.lafaconmod.Category;

public class Item {

	private String name;
	private Category category;
	private int quantity;
	private Double price;

	public Item(String _name, Category _category, int _quantity, Double _price) {
		this.name = _name;
		this.category = _category;
		this.quantity = _quantity;
		this.price = _price;
	}

	public Item(String _name, Category _category, int _quantity) {
		this.name = _name;
		this.category = _category;
		this.quantity = _quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", category=" + category + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
