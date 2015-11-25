package dbo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionPool 
{
	
	public JdbcConnectionPool()
	{
		
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection conn = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://184.170.246.140:3306/dbchicago","root","Newuser123");
		
		return conn;
	}

}
