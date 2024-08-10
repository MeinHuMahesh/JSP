package DatabaseConnection;
import java.sql.*;

public class DatabaseConnection {
	private Connection conn;
	
	public Connection connect() {
		String urldb ="jdbc:mysql://localhost:3306/hotelmanagement";
		String userdb="root";
		String passworddb="mahesh123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =DriverManager.getConnection(urldb,userdb,passworddb);
			
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeconnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
