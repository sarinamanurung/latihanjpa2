
package com.eksad.latihanjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

import com.eksad.latihanjpa.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Employee> getAll() {
		return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
		
	}

	@Override
	public Employee getById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		entityManager.persist(employee);
	}
	
	@Transactional
	@Override
	public void update(Employee employee) {
		//entityManager.getTransaction().begin();
		entityManager.merge(employee);
		//entityManager.getTransaction().commit();
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		//entityManager.getTransaction().begin();
		Employee employee = getById(id);
		entityManager.remove(employee);
		//entityManager.getTransaction().commit();
	}
	
	@Transactional
	@Override
	public List<Employee> getByName(String name) {
		//Employee employee = getByName(name);
		//entityManager.find(employee, id);
		return entityManager.createQuery("Select e from Employee e where e.name like ?0", Employee.class)
				.setParameter(0, "%"+name+"%").getResultList();
		
		
	}
	
	
}
