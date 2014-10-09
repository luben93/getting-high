package BO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

//import DB.Item;



import DB.NoSuchSQLLine;
import DB.singeltonSQLUser;

public class Fasade {
	private UserCopy usr=null;
	private DBHandler handler;
	
	public Fasade(){
		handler=new DBHandler();
	}
	
	public void logout(){
		usr=null;
	}
	
	public double getTotPrice() throws NotLoggedInExecption{
		double out=0.0;
		ArrayList<ItemCopy> cart = getCart();
		if(!cart.isEmpty())
		for (ItemCopy item : cart) {
			out=out+item.getPrice();
		}
		
		return out;
	}
	
	public void doBuy(boolean bankpayment) throws SQLException{
		if(bankpayment){
			try {
				singeltonSQLUser._getInstance().payAllItemsInHistory(usr.getUserMail());
			} catch (NotLoggedInExecption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public ArrayList<ItemCopy> getCart() throws NotLoggedInExecption{
		return handler.getCart(usr.getUserMail());
	}

public static ArrayList<ItemCopy> getItemList(String cat){
	return DBHandler.getItemsByCat(cat);
}

public void addItemToCart(ItemCopy item) throws SQLException, NotLoggedInExecption{
	singeltonSQLUser._getInstance().addItemsToHistory(item, usr.getUserMail());
}
public boolean login(String mail,String pass) throws NoSuchSQLLine, NoSuchAlgorithmException, UnsupportedEncodingException{
	usr = new UserCopy(mail);
	return usr.login(pass);
}

}
