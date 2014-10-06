package BO;

import java.util.ArrayList;
import DB.Item;
import DB.singeltonSQLUser;

public class ItemCopy extends Item {
	

	public ItemCopy(Item item) {
		super(item.getName(), item.getDesc(), item.getPrice(), item.getSaldo(), item.getCat());
	}

}
