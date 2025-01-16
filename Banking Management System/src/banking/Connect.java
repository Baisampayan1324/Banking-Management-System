package banking;

import java.sql.*;

public class Connect
{
	Connection c;
	Statement s;
	public Connect()
	{
		try
		{
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "solodragon1821@");
			s = c.createStatement();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
