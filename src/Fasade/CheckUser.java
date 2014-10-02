package Fasade;
import BO.TempUser;
public class CheckUser {
	private TempUser US ;
	
	public CheckUser()
		{
		TempUser US = new TempUser();
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
