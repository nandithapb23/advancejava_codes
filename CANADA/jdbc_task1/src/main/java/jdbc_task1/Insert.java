package jdbc_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.Establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
		//3.create statement
		Statement statement=connection.createStatement();
		//4.execute statement
		statement.execute("insert into student values(2,'harsh',100)");
		//5.close
		connection.close();
		System.out.println("inserted");
	}
}
