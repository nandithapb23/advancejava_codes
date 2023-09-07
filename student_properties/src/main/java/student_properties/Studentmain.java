package student_properties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Studentmain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id");
		int id=scanner.nextInt();
		System.out.println("enter the name");
		String name=scanner.next();
		System.out.println("enter the marks");
		double marks=scanner.nextDouble();
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setMarks(marks);
		
		Studentcrud studentcrud=new Studentcrud();
		try {
			studentcrud.saveStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
