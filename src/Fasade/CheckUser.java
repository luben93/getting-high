package Fasade;

import BO.TempUser;

public class CheckUser {
	
	public CheckUser()
		{
	
		}
	
		
	public boolean checkUserName(String password)
	{
		return US.checkUserName(password);
		//return true;
	}
	
	public boolean checkPassword(String password)
	{
		return true;
	}

}
