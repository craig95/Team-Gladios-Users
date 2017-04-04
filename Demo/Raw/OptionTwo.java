import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OptionTwo
{
	private Connection db; //!< This is the database object 
	private Statement stmt; //!< This is the statement object used to execute the queries
	
	/*
	* @param o Dabase object
	* @todo Assigns the passed object to the local databse object. Then creates the Statement object, which will be used to execute the SQL queries
	*
	*
	*/
	public OptionTwo(Connection o)
	{
		db=o;
		stmt=db.createStatement();
	}
	/*
	* @param username Username string
	* @param password Password string
	* @param firstname Firstname string
	* @param lastname Lastname string
	* @param email Email string
	*
	* @todo It first checks if the database has the user, if not it adds the user.
	*
	* @return Returns a boolean to state if the user was successfully registered 
	*/
	
	public boolean registerUser(String username,String password,String firstname,String lastname,String email)
	{
		String sql="SELECT * FROM "+/* please insert table name here */ + "WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			return false;
		sql="INSERT INTO ";
		sql += /* please insert table name here*/ ;
		sql +="VALUES (";
		sql += /* please arrange  and on (don,t forget to comma separate) the parameters according to how the columns are set up */ ;
		stmt.executeUpdate(sql);
		return true;
	}
	
	/*
	* @param username Username string
	* @param password Password string
	*
	* @todo It checks if the user exists in the databse
	*
	* @return Returns -1 if the user does not exist on the database. It returns the user's ID if the user exists on the database
	*/
	
	public int login(String username,String password)
	{
		String sql="SELECT * FROM "+/* please insert table name here */ + "WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
		ResultSet result=stmt.executeQuery(sql);
		if(result.next())
			return result.getInt("id");
		else
			return -1;
	}
	
	/*
	* @param username Username string
	* 
	* @todo Removes the user from the database
	*
	* @return Returns a boolean stating whether or not the user was successfully removed from the database.
	*/
	public boolean removeUser(String username)
	{
		String sql="DELETE FROM "+/* please insert table name here */ + "WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
		ResultSet result=stmt.executeUpdate(sql);
		db.commit();
		String sql="SELECT * FROM "+/* please insert table name here */ + "WHERE username=\'"+username+"\' AND password=\'"+password+"\' ;";
		result=stmt.executeQuery(sql);
		if(result.next())
			return false;
		else
			return true;
	}
}