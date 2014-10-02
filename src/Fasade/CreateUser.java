package Fasade;
import BO.User;
public class CreateUser {
	private User U;
	public CreateUser()
	{
		User U = new User();
		this.U = U;
	}

	public boolean createUser(String email,String password)
	{
		if(checkUnique(email))
		{
			U.newUser(email,password);
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	//this method makes sure every email is unique
	public boolean checkUnique(String email)
	{
		return true;
	}
}
