package employee_servlet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import employee_servlet.dto.Employee;

public class Employedao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nanditha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public Employee savEmployee(Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

	public Employee loginEmployee(String email, String password) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("select e from Employee e where e.email=?1 and e.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		Employee employee=(Employee) query.getSingleResult();
		if(query!=null) {
			return employee;
		}else {
			return null;
		}

	}
}
