package BO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import DB.NoSuchSQLLine;
import DB.User;
import DB.singeltonSQLUser;

public class Fasade {
public void createUser(String mail,String password) throws SQLException{
	try {
		BO.CreateUser create = new BO.CreateUser(mail,User.hasher(password));
	} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public boolean login(String email,String password) throws NoSuchSQLLine, NoSuchAlgorithmException, UnsupportedEncodingException   {
	singeltonSQLUser sql = singeltonSQLUser._getInstance();
	System.out.println(email);
	User usr=sql.getUserByMail(email);
	String hashpassword=User.hasher(password);
	System.out.println(hashpassword);
	usr.correctPassword(hashpassword);
	
	if( usr.isLoggedIn()){
		return true;
	}else{ 
		return false;
	}
}
}
