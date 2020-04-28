package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Employee;

public class EmployeeDAO {
	private EntityManager entityManager;

	public EmployeeDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void saveEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}

	public Employee findEmployeeById(int id) {
		return entityManager.find(Employee.class, id);
	}

	public void removeEmployee(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(findEmployeeById(id));
		transaction.commit();
	}

	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return query.getResultList();

	}
	public Employee raiseSalary(int id,int raise) {
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		Employee found=findEmployeeById(id);
		if (found!=null) {
			found.setSalary(found.getSalary()+raise);
		}
		
		transaction.commit();
		return found;
		
	}
}
