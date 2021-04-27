package dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import entities.Employee;

public class EmployeeDao {
	private HibernateTemplate hibernateTemplate;
	
		
	@Transactional
	public int addEmployee(Employee employee) {
		Integer rows = (Integer)hibernateTemplate.save(employee);
		return rows;
	}
	
	
	@Transactional
	public List<Employee> getAllEmployee() {
		List<Employee> employess = hibernateTemplate.loadAll(Employee.class);
		return employess;
	}
	
	
	public Employee getEmployeeById(int id) {
		Employee employess=hibernateTemplate.get(Employee.class, id);
		return employess;
	}
	
	@Transactional
	public void updateEmployee(Employee updateEmployee) {
		hibernateTemplate.update(updateEmployee);
	}
	
	@Transactional
	public void deleteEmployee(int id) {
		Employee employee=hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
	}
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
