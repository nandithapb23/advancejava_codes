package jdbc_task1.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Updatedynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/task1", "root", "root");
		PreparedStatement preparedStatement=connection.prepareStatement("update student set studentname=? where id=?");
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		
		int count=preparedStatement.executeUpdate();
		connection.close();
		System.out.println(count+"rows got affected");
	}
}
