package manytooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytooneuni.dto.Students;

public class Studentdao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void savestudent(Students students) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(students);
		entityTransaction.commit();
		
	}
	public void updatestudents(int id,Students students) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Students students2=entityManager.find(Students.class, id);
		if(students2!=null) {
			students.setSid(id);
			students.setSchool(students2.getSchool());
			entityTransaction.begin();
			entityManager.merge(students);
			entityTransaction.commit();
		}else {
			System.out.println("id doesnt exist");
		}
		
	}
	public void deletestudents(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Students students=entityManager.find(Students.class, id);
		if(students!=null) {
			entityTransaction.begin();
			entityManager.remove(students);
			entityTransaction.commit();
		}else {
			System.out.println("id doesnt exist");
		}
		
	}
	public void getstudentbyid(int id) {
		EntityManager entityManager=getEntityManager();
		Students students=entityManager.find(Students.class, id);
		System.out.println(students);
		
	}
	public void getallstudents() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select a from Students a");
		System.out.println(query.getResultList());
		
		
	}
}
