package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQLhelper
 * @author luben
 *
 */
public class SQLUser {
public SQLUser(){
	System.out.println("good morning");
	try {
        Connection conn= connect("130.237.84.69", "mydb", "tester", "12345");
        Statement myStmt= conn.createStatement();
        
        ResultSet rs = myStmt.executeQuery("select * from users");
       //*
        while(rs.next()){
        	System.out.println(rs.getString("username")+rs.getString("password"));
        }
        //*/
    } catch (Exception ex) {
        // handle the error
    	System.err.println(ex.getMessage());
    }
}

/**
 * 
 * @param ip
 * @param table
 * @param user
 * @param pass
 */
private Connection connect(String ip,String table,String user,String pass){
	
	Connection conn=null;
	try {
        Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+table,user,pass);
       // System.out.println(conn.getClientInfo());
    } catch (SQLException | ClassNotFoundException ex) {
        // handle the error
    	System.err.println(ex.getMessage());
    	ex.printStackTrace();
    }
    return conn;

}







}
