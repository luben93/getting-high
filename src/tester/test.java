package tester;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import DB.Item;
import DB.User;
import DB.singeltonSQLUser;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singeltonSQLUser tester=new singeltonSQLUser();
		
		//tester.createUser();
		//User tmp;
		//System.out.println(tmp=tester.getUserByMail("junky@home.com"));
		ArrayList<Item> list=tester.getItemsByCategory("drugs");
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}/*
		try {
			String hashpass=User.hasher("12345");
			System.out.println(hashpass);
			System.out.println(tmp.correctPassword(hashpass));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		
	}

}
