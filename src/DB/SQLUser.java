package DB;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

/**
 * SQLhelper
 * 
 * @author luben
 *
 */
abstract class SQLUser{
	private Connection conn;

	public SQLUser() {
		// test();
		conn = connect("130.237.84.69", "mydb", "tester", "good");
	}
	
	public void kill() throws SQLException{
		conn.close();
	}

	public boolean createUser() {
		return false;

	}

	public boolean addItemsToCart() {
		return false;

	}

	public Cart getCart(User user) {
		return null;
	}

	public ArrayList<Item> getItemsByCategory(String cat) {
		ArrayList<Item> out = new ArrayList<Item>();
		try {
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt
					.executeQuery("select * from item where category = '" + cat
							+ "'");
			Item item = null;
			while (rs.next()) {
				item = new Item(rs.getInt("itemid"), rs.getString("name"),
						rs.getString("desc"), rs.getDouble("price"),
						rs.getInt("saldo"), rs.getString("category"));
				out.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	public User getUserByMail(String mail) throws NoSuchSQLLine {
		User out = null;
		try {
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt
					.executeQuery("select * from users where mail = '" + mail
							+ "'");
			while (rs.next()) {
				out = new User(rs.getString("mail"),
						rs.getString("password"));
			}
			if(out != null){
				throw new NoSuchSQLLine("no user with that mail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	/*
	public ArrayList<History> getHistoryByUserId(int id){
		ArrayList<History> out = new ArrayList<History>();
		try {
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt
					.executeQuery("select * from history where userid = '" + id
							+ "'");
			History history = null;
			while (rs.next()) {
				history = new History(rs.getInt("historyId"), rs.getInt("user"),rs.getInt(" history"), rs.getInt("payed"));
						out.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}*/
/*
	private void test() {

		try {
			Connection conn = connect("83.251.242.112", "drugs", "admin",
					"good@password");
			Statement myStmt = conn.createStatement();

			ResultSet rs = myStmt.executeQuery("select * from users");
			
			while (rs.next()) {
				System.out.println(rs.getString("username")
						+ rs.getString("password"));
			}
			
		} catch (Exception ex) {
			// handle the error
			System.err.println(ex.getMessage());
		}
	}
*/
	/**
	 * 
	 * @param ip
	 * @param table
	 * @param user
	 * @param pass
	 */

	//this connection only happens once - start 
	private Connection connect(String ip, String table, String user, String pass) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + ip + "/"
					+ table, user, pass);
			// System.out.println(conn.getClientInfo());
		} catch (SQLException | ClassNotFoundException ex) {
			// handle the error
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		return conn;

	}

	/**
	 * 
	 * @param email
	 * @param hashpassword
	 * @return  SQL status 0 or 1 
	 * @throws SQLException
	 */
	public int createUser(String email,String hashpassword) throws SQLException
	{
		//	PreparedStatement pstmt = null;


		// TODO Auto-generated catch block

		//INSERT INTO `drugs`.`users` (`idusers`, `sha256hash`, `mail`) VALUES ('2', 'mathias', 'odd');

		//		String insertQuery = "INSERT INTO USERS (username, password)"
		//				+"VALUES"
		//				+"(?, ?)";

		//		try {
		//			hashpassword=User.hasher(hashpassword);
		//		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//			
		//		String insertQuery  = "INSERT INTO `drugs`.`users` ('iduser',`sha256hash`, `mail`) VALUES (?, ?, ?)";
		//		pstmt = (PreparedStatement) conn.prepareStatement(insertQuery);
		//		pstmt.setInt(1, 3);
		//		pstmt.setString(2, hashpassword);
		//		pstmt.setString(3, email);
		//		
		//		
		//		
		//		return pstmt.executeUpdate(insertQuery);
		try {
			getUserByMail(email);
			throw new NoSuchSQLLine("that user already exists");

			//user doesn't exist, we can create this one
		} catch (NoSuchSQLLine e) {
			try {
				hashpassword=User.hasher(hashpassword);
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException eu) {
				// TODO Auto-generated catch block
				eu.printStackTrace();
			}
		  //perform SQL query
			Statement test = conn.createStatement();
			return test.executeUpdate("INSERT INTO users ( `password`, `mail`) VALUES ('"+hashpassword+"','" +email+"')");
		}		


	}

}