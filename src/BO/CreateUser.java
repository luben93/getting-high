package BO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import DB.User;
import DB.singeltonSQLUser;
public class CreateUser {
	public CreateUser(String email,String password) throws SQLException
	{
		singeltonSQLUser sql=singeltonSQLUser._getInstance();
		try {
			sql.createUser(email, User.hasher(password));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
}
