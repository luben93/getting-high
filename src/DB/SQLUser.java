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
public class SQLUser {
	private Connection conn;

	public SQLUser() {
		// test();
		conn = connect("83.251.242.112", "drugs", "admin", "good@password");
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

	public User getUserByMail(String mail) {
		User out = null;
		try {
			Statement myStmt = conn.createStatement();
			ResultSet rs = myStmt
					.executeQuery("select * from users where mail = '" + mail
							+ "'");
			while (rs.next()) {
				byte[] bytearr = User.toBytes((rs.getString("sha256hash").toCharArray()));
				out = new User(rs.getInt("idusers"),rs.getString("mail"),bytearr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;

	}

	private void test() {
		System.out.println("good morning");
		try {
			Connection conn = connect("83.251.242.112", "drugs", "admin",
					"good@password");
			Statement myStmt = conn.createStatement();

			ResultSet rs = myStmt.executeQuery("select * from users");
			// *
			while (rs.next()) {
				System.out.println(rs.getString("username")
						+ rs.getString("password"));
			}
			// */
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
	private Connection connect(String ip, String table, String user, String pass) {
		// ////fffffufuuuuuuuuuuu test only
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

}
