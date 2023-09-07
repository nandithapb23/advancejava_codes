package student_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Studentcrud {

	public Connection getConnection() throws SQLException, IOException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"),properties.getProperty("password"));
		return connection;
	}
	
	public Student saveStudent(Student student) throws SQLException, IOException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getName());
		preparedStatement.setDouble(3, student.getMarks());
		preparedStatement.execute();
		connection.close();
		System.out.println("inserted");
		return student;
		
	}
}
