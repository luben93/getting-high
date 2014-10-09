package BO;

import DB.Item;

public class ItemCopy extends Item {
	

	public ItemCopy(Item item) {
		super(item.getName(), item.getDesc(), item.getPrice(), item.getSaldo(), item.getCat());
	}

}
