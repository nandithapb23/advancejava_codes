package onetoone_bi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_bi.dto.Aadhar;
import onetoone_bi.dto.Person;

public class Personmain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		//cascade for persist
		
//		Person person=new Person();
//		person.setName("karan");
//		person.setAddress("chennai");
//		
//		Aadhar aadhar=new Aadhar();
//		aadhar.setAname("karan");
//		aadhar.setAddress("chennai");
//		
//		person.setAadhar(aadhar);
//		aadhar.setPerson(person);
//		
//		entityTransaction.begin();
//		entityManager.persist(person);
//		entityTransaction.commit();
		
		
		//cascade for merge
		
//		Person person=entityManager.find(Person.class, 5);
//		person.setId(5);
//		person.setName("arun");
//		person.setAddress("bangalore");
//		
//		Aadhar aadhar=new Aadhar();
//		aadhar.setAid(4);
//		aadhar.setAname("arun");
//		aadhar.setAddress("bangalore");
//		
//		person.setAadhar(aadhar);
//		aadhar.setPerson(person);
//		
//		entityTransaction.begin();
//		entityManager.merge(person);
//		entityTransaction.commit();
		
		
		//cascade for remove
		Person person=entityManager.find(Person.class, 5);
		Aadhar aadhar=entityManager.find(Aadhar.class, 4);
		
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
	}
}