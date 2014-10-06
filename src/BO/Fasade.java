package BO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.Item;
import DB.NoSuchSQLLine;
import DB.User;
import DB.singeltonSQLUser;

public class Fasade {
	private User usr=null;
	private DBHandler handler;
	
	public Fasade(){
		handler=new DBHandler();
	}
	
	public void logout(){
		usr=null;
	}
	
	public double getTotPrice(){
		double out=0.0;
		ArrayList<Item> cart = getCart();
		if(!cart.isEmpty())
		for (Item item : cart) {
			out=out+item.getPrice();
		}
		
		return out;
	}
	
	public void doBuy(boolean bankpayment) throws SQLException{
		if(bankpayment){
			singeltonSQLUser._getInstance().payAllItemsInHistory(usr);
		}	
	}
	
	public ArrayList<Item> getCart(){
		return handler.getCart(usr);
	}

public static ArrayList<Item> getItemList(String cat){
	return DBHandler.getItemsByCat(cat);
}

public void addItemToCart(Item item) throws SQLException{
	singeltonSQLUser._getInstance().addItemsToHistory(item, usr);
}
public boolean login(String email,String password) throws NoSuchSQLLine, NoSuchAlgorithmException, UnsupportedEncodingException   {
	singeltonSQLUser sql = singeltonSQLUser._getInstance();
	System.out.println(email);
	usr=sql.getUserByMail(email);
	String hashpassword=User.hasher(password);
	System.out.println(hashpassword);
	usr.correctPassword(hashpassword);
	
	if( usr.isLoggedIn()){
		return true;
	}else{ 
		usr=null;
		return false;
	}
}
}
