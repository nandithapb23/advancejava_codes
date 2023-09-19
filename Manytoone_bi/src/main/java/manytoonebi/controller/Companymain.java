package manytoonebi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoonebi.dto.Company;
import manytoonebi.dto.Employee;

public class Companymain {

	public static void main(String[] args) {
		Company company=new Company();
		company.setName("wipro");
		company.setAddress("bangalore");
		
		Employee e1=new Employee();
		e1.setEname("tharun");
		e1.setSalary(60000);
		
		Employee e2=new Employee();
		e2.setEname("arun");
		e2.setSalary(40000);
		
		List<Employee> list=new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		
		e1.setCompany(company);
		e2.setCompany(company);
		company.setList(list);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
//		entityTransaction.begin();
//		entityManager.persist(e1);
//		entityManager.persist(e2);
//		entityManager.persist(company);
//		entityTransaction.commit();
		
		Employee employee=entityManager.find(Employee.class, 1);
		System.out.println(employee);
	}
}
