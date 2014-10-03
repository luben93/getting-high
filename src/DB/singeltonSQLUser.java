package DB;

public class singeltonSQLUser extends SQLUser {
final private static singeltonSQLUser sqluser=new singeltonSQLUser();
	public singeltonSQLUser() {
		// TODO Auto-generated constructor stub
	}

	public singeltonSQLUser _getInstance(){
		return sqluser;
	}

}
