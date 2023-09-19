package onetoone_bi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_bi.dto.Aadhar;
import onetoone_bi.dto.Person;

public class Personmain {

	public static void main(String[] args) {
		Person person=new Person();
		person.setName("ram");
		person.setAddress("bangalore");
		
		Aadhar aadhar=new Aadhar();
		aadhar.setAname("ram");
		aadhar.setAddress("bangalore");
		
		person.setAadhar(aadhar);
		aadhar.setPerson(person);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
//		entityTransaction.begin();
//		entityManager.persist(aadhar);
//		entityManager.persist(person);
//		entityTransaction.commit();
		
		Person person2=entityManager.find(Person.class, 1);
		System.out.println(person2);
	}
}
