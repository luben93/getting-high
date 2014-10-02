package tester;

import java.util.ArrayList;

import DB.Item;
import DB.SQLUser;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLUser tester=new SQLUser();
		System.out.println(tester.getUserByMail("junky@home.com"));
		//ArrayList<Item> list=tester.getItemsByCategory("drugs");
		/*for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
	
	}

}
