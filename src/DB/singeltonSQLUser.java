package DB;

import DB.SQLUser;

public class singeltonSQLUser extends SQLUser {
final private static singeltonSQLUser sqluser=new singeltonSQLUser();
	private singeltonSQLUser() {
		//System.out.println("hej");
		// TODO Auto-generated constructor stub
	}

	public static singeltonSQLUser _getInstance(){
		//System.out.println("retreiving instance");
		return sqluser;
	}

}
