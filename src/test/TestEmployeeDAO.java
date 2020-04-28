package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmployeeDAO;
import domain.Employee;

public class TestEmployeeDAO {
  public static void main(String[] args) {
	  EntityManagerFactory   emf=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	  EntityManager entityManager=emf.createEntityManager();
	  EmployeeDAO empDAO=new EmployeeDAO(entityManager);
	  Employee employee1=new Employee(1,"fatih","karakas",5000);
	  Employee employee2=new Employee(2,"fatih","karakas",5000);
	  Employee employee3=new Employee(3,"fatih","karakas",5000);
	  empDAO.saveEmployee(employee1);
	  empDAO.saveEmployee(employee2);
	  empDAO.saveEmployee(employee3);
	  Employee foundEmployee=empDAO.findEmployeeById(2);
	  System.out.println(foundEmployee);
	  empDAO.removeEmployee(2);
	  Employee foundEmployee1=empDAO.findEmployeeById(2);
	  System.out.println(foundEmployee1);
	  System.out.println("Get all");
	  List<Employee> e=empDAO.findAllEmployees();
	 System.out.println(e);
	 
	
	 System.out.println( empDAO.raiseSalary(1, 3000));
  }
}
