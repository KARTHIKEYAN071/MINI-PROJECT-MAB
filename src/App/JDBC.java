package App;
import java.sql.*;

public class JDBC {

	
	String url="jdbc:mysql://localhost:3306/MAB";
	String userName="root";
	String password="Karthi@2004.";
	private static Connection con;
	JDBC()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		JDBC.con=DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e)
		{
			System.out.println(e+"Error in jdbc");
		}
		
	}
	public static Connection getcon()
	{
		return con;
	}
	
}