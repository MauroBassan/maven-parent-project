package mavproject;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDipendenze {

	public static void main(String[] args) throws Exception {
		
		// con Class.forName indichiamo di andare a cercare a runtime il riferimento alla classe del driver specifico x mysql
		DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

		String url = "jdbc:mysql://localhost:3306?user=root";

		Connection conn = DriverManager.getConnection(url);
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT 1");
		while(rs.next()) {
			System.out.println("Result = " + rs.getInt(1));
		}
	}
}


