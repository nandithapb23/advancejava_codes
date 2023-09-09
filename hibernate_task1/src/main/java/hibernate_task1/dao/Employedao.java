package hibernate_task1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_task1.dto.Employee;

public class Employedao {

	public void saveEmployee(Employee employee) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		employee.setId(employee.getId());
		employee.setName(employee.getName());
		employee.setSalary(employee.getSalary());
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		
	}
	
	public void updateEmployee(int id,String name,double salary) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		employee.setName(name);
		employee.setSalary(salary);
		
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		
	}
	
	public void deleteemployee(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee employee=entityManager.find(Employee.class, id);
		
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		
	}
	
	public void getemployeebyid(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Employee employee=entityManager.find(Employee.class, id);
		System.out.println(employee);
		
	}
	
	public void getllemployee() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> list=query.getResultList();
		System.out.println(list);
		
	}
}
