package eu.beanstalk.api.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
	private static Connection con;
	private static Statement state;

	private String host;
	private String port;
	private String database;
	private String username;
	private String password;

	public Database(String database)
	{
		this.host = "localhost";
		this.port = "3306";
		this.database = database;
		this.username = "root";
		this.password = "";

		this.connect();
	}

	public Database(String host, String port, String database, String username, String password)
	{
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;

		this.connect();
	}

	private void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
			System.out.println("Database connection: true");
		}
		catch (ClassNotFoundException | SQLException e1)
		{
			System.out.println("Database connection: false");
		}
	}

	public static void execute(String callable)
	{
		try
		{
			state = con.createStatement();
			state.executeUpdate(callable);
			state.close();
		}
		catch (SQLException e)
		{
		}
	}

	public static ResultSet query(String callable)
	{
		try
		{
			state = con.createStatement();
			ResultSet result = state.executeQuery(callable);
			return result;
		}
		catch (SQLException e)
		{
		}
		return null;
	}

	public static boolean exist(String callable)
	{
		ResultSet result = Database.query(callable);
		int row = 0;
		try
		{
			while (result.next())
			{
				row = result.getRow();
			}
		}
		catch (SQLException e)
		{
		}
		if (row != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
