package manytomanybi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybi.dto.Language;
import manytomanybi.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		Person p1=new Person();
		p1.setName("gagan");
		p1.setAddress("bangalore");
		
		Person p2=new Person();
		p2.setName("ram");
		p2.setAddress("chennai");
		
		
		Language l1=new Language();
		l1.setName("english");
		l1.setOrigin("england");
		
		Language l2=new Language();
		l2.setName("kannada");
		l2.setOrigin("karnataka");
		
		List<Person> list=new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
	
		
		List<Language> l_list1=new ArrayList<Language>();
		l_list1.add(l1);
		l_list1.add(l2);
	
		
		p1.setList(l_list1);
		p2.setList(l_list1);
		
		l1.setList(list);
		l2.setList(list);
		
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
//		entityTransaction.begin();
//		entityManager.persist(p1);
//		entityManager.persist(p2);
//		entityManager.persist(l1);
//		entityManager.persist(l2);
//		entityTransaction.commit();
//		
//	Person person=entityManager.find(Person.class, 1);
//	System.out.println(person);
		
		Language language=entityManager.find(Language.class, 1);
		System.out.println(language);
	}
}
