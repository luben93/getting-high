package DB;

import java.util.ArrayList;

public class Cart {
	private User user;
	private ArrayList<Item> list;

	public Cart(User user) {
		this.user = user;
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
