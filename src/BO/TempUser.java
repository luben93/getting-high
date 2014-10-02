package BO;

import java.sql.SQLException;

import DB.SQLUser;

public class TempUser {
	
private SQLUser SQLU;
	

	
	public TempUser()
	{
		SQLUser SQLU = new SQLUser();
		this.SQLU = SQLU;
		
	}
	
	public void getItems()
	{
		
	}
	
	public void getPrice()
	{
		
	}
	
	public void getCart()
	{
		
	}
	
	public void newUser(String name,String password) 
	{
		
		try {
			SQLU.createUser(name, password);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					
		}
				
	}
	
	public boolean checkUnique(String email)
	{
		return true;
	}
	
	public boolean checkUserName(String email)
	{
		return true;
	}
	
	public boolean checkUserPassword(String password)
	{
		return true;
	}

}
