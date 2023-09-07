package student_properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproperties", "root", "root");
		
		Student s1=new Student();
		s1.setId(2);
		s1.setName("vinay");
		s1.setMarks(60);
		
		Student s2=new Student();
		s2.setId(3);
		s2.setName("ajay");
		s2.setMarks(80);
		
		Student s3=new Student();
		s3.setId(4);
		s3.setName("kiran");
		s3.setMarks(80);
		
		List<Student> list=new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?)");
		for(Student student:list) {
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setDouble(3, student.getMarks());
			preparedStatement.addBatch();
			System.out.println("inserted");
			
		}
		preparedStatement.executeBatch();
		connection.close();
	}
}
