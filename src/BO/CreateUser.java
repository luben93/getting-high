package BO;
import java.sql.SQLException;

import DB.singeltonSQLUser;
public class CreateUser {
	public CreateUser(String email,String hashpassword) throws SQLException
	{
		singeltonSQLUser sql=singeltonSQLUser._getInstance();
		sql.createUser(email, hashpassword);
	
	
	}
}
