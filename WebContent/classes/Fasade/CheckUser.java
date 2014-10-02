package Fasade;
import BO.User;
public class CheckUser {
	private User US ;
	
	public CheckUser()
		{
		User US = new User();
		this.US = US;
	}
		
	public boolean checkUserName(String password)
	{
		//return US.checkUserName(password);
		return true;
	}
	
	public boolean checkPassword(String password)
	{
		return true;
	}

}
