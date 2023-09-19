package manytomanyuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytomanyuni.dto.Language;
import manytomanyuni.dto.Person;

public class Persondao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveperson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	public void savelanguage(Language language) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(language);
		entityTransaction.commit();
	}
	public void updateperson(int id,Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person2=entityManager.find(Person.class, id);
		if(person2!=null) {
			person.setId(id);
			person.setList(person2.getList());
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("id doesnt exist");
		}
		
	}
	public void deleteperson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}else {
			System.out.println("id doesnt exist");
		}
		
	}
	public void getpersonbyid(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		System.out.println(person);
		
	}
	public void getallperson() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from Person p");
		System.out.println(query.getResultList());
		
	}
}
