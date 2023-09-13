package onetomanyuni.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomanyuni.dto.Company;
import onetomanyuni.dto.Employee;

public class Companydao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void savecompany(Company company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		List<Employee> list=company.getList();
		for(Employee employee:list) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
		
	}
	public void updatecompany(int id,Company company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company company2=entityManager.find(Company.class, id);
		if(company2!=null) {
			entityTransaction.begin();
			company.setCid(id);
			List<Employee> list=company.getList();
			for(Employee employee:list) {
				entityManager.merge(employee);
			}
			entityManager.merge(company);
			entityTransaction.commit();
		}
		
	}
	public void deletecompany(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company company=entityManager.find(Company.class, id);
		entityTransaction.begin();
		List<Employee> list=company.getList();
		for(Employee employee:list) {
			entityManager.remove(employee);
		}
		entityManager.remove(company);
		entityTransaction.commit();
		
	}
	public void getcompanybyid(int id) {
		EntityManager entityManager=getEntityManager();
		Company company=entityManager.find(Company.class, id);
		System.out.println(company);
		
	}
	public void getallcompany() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select c from Company c");
		System.out.println(query.getResultList());
	}
}
