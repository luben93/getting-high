package BO;
import DB.*;

import java.util.ArrayList;

public class DBHandler {

	public DBHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<ItemCopy> getCart(String mail){
		ArrayList<ItemCopy> copy=new ArrayList<ItemCopy>();
		ArrayList<Item> org=singeltonSQLUser._getInstance().getCart(mail);
		for (Item item : org) {
			copy.add(new ItemCopy(item));
		}
		return copy;
	}
	
	public static ArrayList<ItemCopy> getItemsByCat(String cat){
		ArrayList<ItemCopy> copy=new ArrayList<ItemCopy>();
		ArrayList<Item> org=singeltonSQLUser._getInstance().getItemsByCategory(cat);
		for (Item item : org) {
			copy.add(new ItemCopy(item));
		}
		return copy;
	}
	

}
