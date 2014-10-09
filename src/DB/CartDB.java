package DB;

import java.util.ArrayList;

public class CartDB {
	private ArrayList<Item> list;

	public CartDB() {
		list = new ArrayList<Item>();
	}

	public boolean addItemsToCart(Item item) {
		return list.add(item);
	}

	public void emptyCart() {
		list = new ArrayList<Item>();
	}

	public ArrayList<Item> getItemsFromCart() {
		return list;
	}
}
