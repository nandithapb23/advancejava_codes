package jdbc_task1.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertdynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String studentname=scanner.next();
		System.out.println("enter the marks");
		int marks=scanner.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, studentname);
		preparedStatement.setInt(3, marks);
		
		preparedStatement.execute();
		connection.close();
		System.out.println("inseted");
	}
}
