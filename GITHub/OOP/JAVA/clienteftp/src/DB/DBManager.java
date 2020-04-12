package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import entidades.Conexion;

/*
public class DBManager {
	private static DBManager instancia;
	
	public static DBManager getinstancia() {
		if (instancia == null)
			instancia = new DBManager();
		return instancia;
	
	}
	/*
	public void insert(Conexion c) {
		try {

			String userName = "alan";
			String password = "alan";
			String url = "jdbc:sqlserver://localhost:1433";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, userName,password);

			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

*/

public class DBManager {

	private static final String nombre = "servftp";
	private static final String password = "servftp";
	private static final String url = "jdbc:sqlserver://localhost:1433";
	
	
	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			c = DriverManager.getConnection(url,nombre,password);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
}
		
		return c;
	}
}
	
		
		/*
	public static Connection Connection() {
		// TODO Auto-generated method stub
		String nombre = "alan";
		String password = "alan";
		String url = "jdbc:sqlserver://localhost:1433";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url,nombre,password);

	
		con.close();

	}
}
*/

	

