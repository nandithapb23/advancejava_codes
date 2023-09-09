package hibernate_task1.controller;

import java.util.Scanner;

import hibernate_task1.dao.Employedao;
import hibernate_task1.dto.Employee;

public class EmployeeMaain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Employee employee=new Employee();
		Employedao employedao=new Employedao();
		boolean check=true;
		do {
			System.out.println("1.save employee");
			System.out.println("2.update employee");
			System.out.println("3.delete employee");
			System.out.println("4.get employee by id");
			System.out.println("5.get all employee");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the salary");
				double salary=scanner.nextDouble();
				
				employee.setId(id);
				employee.setName(name);
				employee.setSalary(salary);
				
				employedao.saveEmployee(employee);
			}
			break;
			case 2:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the name");
				String name=scanner.next();
				System.out.println("enter the salary");
				double salary=scanner.nextDouble();
				
				employee.setId(id);
				employee.setName(name);
				employee.setSalary(salary);
				
				employedao.updateEmployee(id, name, salary);
			}
			break;
			
			case 3:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				
				employee.setId(id);
				employedao.deleteemployee(id);
			}
			break;
			case 4:{
				System.out.println("enter the id");
				int id=scanner.nextInt();
				
				employee.setId(id);
				employedao.getemployeebyid(id);
			}
			break;
			case 5:{
				employedao.getllemployee();
			}
			break;

			default:
				break;
			}
		} while (check);
	}
}
