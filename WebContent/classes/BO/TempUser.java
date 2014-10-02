package BO;

import java.sql.SQLException;

import DB.SQLUser;

public class TempUser {
	
private SQLUser SQLU;
	

	
	public TempUser()
	{
		SQLU = new SQLUser();

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
	
	public void newUser(String email,String password) throws SQLException
	{
		
		
			SQLU.createUser(email, password);
		
		
	
				
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
