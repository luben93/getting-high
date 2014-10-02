package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*; 

import com.mysql.jdbc.PreparedStatement;


public class SQLUser
{

	private Connection mycon;
	private Statement myStmt;
	private ResultSet myRs;

	public SQLUser()
	{


		try{
			// load the driver before trying the connection!!!!
			Class.forName("com.mysql.jdbc.Driver");

			//get a connection
			this.mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYDB","root","root");
			//Class.forName("com.mysql.jdbc.Driver"); 
			//create a statement
			this.myStmt = mycon.createStatement();


			//execute SQL query 
			this.myRs = myStmt.executeQuery("select * from users");
			//ResultSet myRs = myStmt.executeQuery("INSERT INTO users VALUES (m,m)");


			//process the result
			while(myRs.next())
			{
				System.out.println(myRs.getString("password") + ", " + myRs.getString("username"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void createUser(String name,String password) throws SQLException
	{
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO USERS (username, password)"
				+"VALUES"
				+"(?, ?)";
		pstmt = (PreparedStatement) mycon.prepareStatement(insertQuery);
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.executeUpdate();


	}
	
	public void updateSaldo()
	{
		
	}
	
	public void Pay()
	{
		
	}
	
	public boolean checkUserUnique()
	{
		return true;
		
	}
}



