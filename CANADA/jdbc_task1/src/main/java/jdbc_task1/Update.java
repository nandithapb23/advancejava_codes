package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
		//create statement
		Statement statement=connection.createStatement();
		//execute statement
		int count=statement.executeUpdate("update student set studentname='ram' where id=2");
		//close
		connection.close();
		
		System.out.println(count+"row got affected");
	}
}
