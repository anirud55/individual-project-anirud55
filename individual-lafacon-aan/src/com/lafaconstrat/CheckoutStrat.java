package com.lafaconstrat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lafaconmod.Item;

public interface CheckoutStrat {

	public ArrayList<String> checkout(List<Item> items) throws IOException;

}
