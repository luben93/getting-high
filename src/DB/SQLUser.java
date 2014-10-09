package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 * SQLhelper
 * 
 * @author luben
 *
 */
abstract class SQLUser {
	private Connection conn;

	public SQLUser() {
		// test();
		conn = connect("83.251.251.65", "mydb", "tester", "good@password");
		
		/*Context initCtx = new InitialContext();

		Context envCtx = (Context) initCtx.lookup("java:comp/env");

		DataSource ds = (DataSource)

		envCtx.lookup("jdbc/drugs");		
		conn=null;*/
	}

	public void kill() throws SQLException {
		conn.close();
	}

	
	
	public Item getItemByName(String name) {
		Item out = null;
		try {
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt
					.executeQuery("select * from item where iditem = '" + name
							+ "'");
			while (rs.next()) {
				out = new Item(rs.getString("iditem"), rs.getString("desc"),
						rs.getDouble("price"), rs.getInt("saldo"),
						rs.getString("category"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	public int addItemsToHistory(Item item, String mail) throws SQLException {
		java.sql.PreparedStatement test = conn.prepareStatement("INSERT INTO history (userid,itemid) VALUES ('?,?')");
		test.setString(1, mail);
		test.setString(2, item.getName());
		return test.executeUpdate();
				//.executeUpdate("INSERT INTO history (userid,itemid) VALUES ('"
					//	+ string + "','" + item.getName() + "')");
	}

	public int payAllItemsInHistory(String string) throws SQLException {
		// Statement test = conn.createStatement();
		java.sql.PreparedStatement pstmt = conn
				.prepareStatement("update history set payed = 1 where userid = ?");
		pstmt.setString(1, string);

		return pstmt.executeUpdate();
	}

	/*
	 * public int payItemInHistory(Item item,User user){ return 0; }
	 */

	public ArrayList<Item> getCart(String mail) {
		ArrayList<Item> out = new ArrayList<Item>();
		try {
			java.sql.PreparedStatement pstmt = conn.prepareStatement("select * from history where payed = 0 and userid=''");
			//Statement myStmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(); 
					//myStmt.executeQuery("select * from history where payed = 0 and userid='"+ mail + "'");
			Item item = null;
			while (rs.next()) {
				item = getItemByName(rs.getString("itemid"));
				out.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
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
				item = new Item(rs.getString("iditem"), rs.getString("desc"),
						rs.getDouble("price"), rs.getInt("saldo"),
						rs.getString("category"));
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
				out = new User(rs.getString("mail"), rs.getString("password"));
			}
			if (out == null) {
				throw new NoSuchSQLLine("no user with that mail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	public ArrayList<History> getHistoryByUserId(int id) throws NoSuchSQLLine {
		ArrayList<History> out = new ArrayList<History>();
		try {
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt
					.executeQuery("select * from history where userid = '" + id
							+ "'");
			History history = null;
			while (rs.next()) {
				User usr = getUserByMail(rs.getString("userid"));
				Item item = getItemByName(rs.getString("itemid"));
				boolean payed = false;
				if (rs.getInt("payed") == 1) {
					payed = true;
				}
				history = new History(rs.getInt("historyId"), usr, item, payed);
				out.add(history);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public void removeFromCart(User user) throws SQLException{
		Statement myStmt = conn.createStatement();
		myStmt.executeUpdate(" ");
	}

	/**
	 * 
	 * @param ip
	 * @param table
	 * @param user
	 * @param pass
	 */

	// this connection only happens once - start
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
	 * @return SQL status 0 or 1
	 * @throws SQLException
	 */
	public int createUser(String email, String hashpassword)
			throws SQLException {
		
			
			// perform SQL query
			Statement test = conn.createStatement();
			return test.executeUpdate("INSERT INTO users ( `password`, `mail`) VALUES ('"
							+ hashpassword + "','" + email + "')");

	}

}