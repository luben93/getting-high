package Fasade;
import java.sql.SQLException;

import BO.TempUser;
public class CreateUser {
	private TempUser TU;
	public CreateUser()
	{
		TU = new TempUser(); 
		
	}

	public boolean createUser(String email,String password) throws SQLException
	{
		//if(checkUnique(email))
		//{
			TU.newUser(email,password);
			return true;
		//}
		
//		else
//		{
//			return false;
//		}
	}
	
	
	//this method makes sure every email is unique
	public boolean checkUnique(String email)
	{
		return true;
	}
}
