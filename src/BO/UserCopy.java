package BO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import DB.NoSuchSQLLine;
import DB.User;
import DB.singeltonSQLUser;

public class UserCopy{
	private User usr;
	public UserCopy(String mail) throws NoSuchSQLLine{
		usr = singeltonSQLUser._getInstance().getUserByMail(mail);
	}
	
	public boolean login(String password) throws NoSuchSQLLine, NoSuchAlgorithmException, UnsupportedEncodingException   {
		String hashpassword=User.hasher(password);
		usr.correctPassword(hashpassword);
		if( usr.isLoggedIn()){
			return true;
		}else{ 
			usr=null;
			return false;
		}
	}
	
	public String getUserMail() throws NotLoggedInExecption{
		if (usr.isLoggedIn()){
			return usr.getMail();
		}else{
			throw new NotLoggedInExecption("user not logged in");
		}
	}

}
