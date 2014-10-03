package tester;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.Item;
import DB.NoSuchSQLLine;
import DB.User;
import DB.singeltonSQLUser;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singeltonSQLUser tester=new singeltonSQLUser();
		
		User user;
		try {
			user = tester.getUserByMail("hej");
		
		//System.out.println(tester.getItemByName("item1"));
		System.out.println(tester.payAllItemsInHistory(user));
		ArrayList<Item> list=tester.getItemsByCategory("cat1");
		for (int i=0;i<list.size();i++) {
			tester.addItemsToHistory(list.get(i), user);
		}
		System.out.println(tester.getCart(user));
		
		/*
		try {
			String hashpass=User.hasher("12345");
			System.out.println(hashpass);
			System.out.println(tmp.correctPassword(hashpass));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		} catch (NoSuchSQLLine e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
