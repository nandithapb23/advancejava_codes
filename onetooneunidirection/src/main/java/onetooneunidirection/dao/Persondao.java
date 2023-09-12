package onetooneunidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetooneunidirection.dto.Pancard;
import onetooneunidirection.dto.Person;

public class Persondao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
				
	}
	public void saveperson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Pancard pancard=person.getPancard();
		entityTransaction.begin();
		entityManager.persist(pancard);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	public void updatePerson(int id,Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person persondb=entityManager.find(Person.class, id);
		if(persondb!=null) {
			person.setId(id);
			person.setPancard(persondb.getPancard());
		}
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
		
	}
	public void deleteperson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		Pancard pancard=person.getPancard();
		entityTransaction.begin();
		entityManager.remove(pancard);
		entityManager.remove(person);
		entityTransaction.begin();
		
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
