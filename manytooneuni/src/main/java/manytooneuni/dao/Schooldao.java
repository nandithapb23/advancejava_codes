package manytooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytooneuni.dto.School;

public class Schooldao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveschool(School  school) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(school);
		entityTransaction.commit();
	}
	public void updateschool(int id,School school) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school2=entityManager.find(School.class, id);
		if(school2!=null) {
			school.setId(id);
			entityTransaction.begin();
			entityManager.merge(school);
			entityTransaction.commit();
		}else {
			System.out.println("id doesnt exist");
		}
		
	}
	public void deleteschool(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school=entityManager.find(School.class, id);
		if(school!=null) {
			entityTransaction.begin();
			entityManager.remove(school);
			entityTransaction.commit();
		}else {
			System.out.println("id doesnt exist");
		}
		
	}
	public void getschoolbyid(int id) {
		EntityManager entityManager=getEntityManager();
		School school=entityManager.find(School.class, id);
		System.out.println(school);
		
	}
	public void getallschool() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from School s");
		System.out.println(query.getResultList());
	}
}
