package BO;
import DB.*;
import java.util.ArrayList;

public class DBHandler {

	public DBHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ArrayList<Item> getCart(User usr){
		ArrayList<Item> copy=new ArrayList<Item>();
		ArrayList<Item> org=singeltonSQLUser._getInstance().getCart(usr);
		for (Item item : org) {
			copy.add(new ItemCopy(item));
		}
		return copy;
	}
	
	public static ArrayList<Item> getItemsByCat(String cat){
		ArrayList<Item> copy=new ArrayList<Item>();
		ArrayList<Item> org=singeltonSQLUser._getInstance().getItemsByCategory(cat);
		for (Item item : org) {
			copy.add(new ItemCopy(item));
		}
		return copy;
	}
	

}
