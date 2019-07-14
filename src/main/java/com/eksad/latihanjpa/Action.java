package com.eksad.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SimpleAliasRegistry;

import com.eksad.latihanjpa.dao.EmployeeDAO;
import com.eksad.latihanjpa.model.Employee;

@Configuration
public class Action {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	//@Bean
	public List<Employee> getAll(){
		List<Employee> employees = employeeDAO.getAll();
		
		for (Employee employee : employees) {
			System.out.println("ID : "+employee.getId());
			System.out.println("Name  : "+employee.getName());
			System.out.println("Address: "+employee.getAddress());
			System.out.println("DOB : "+employee.getDob());
			System.out.println("==================================");
		}
		
		return employees;
	}
	
	//@Bean
	public Employee getByID() {
		Employee employee = employeeDAO.getById(12);
		
		System.out.println("Get by ID 12");
		System.out.println("ID : "+employee.getId());
		System.out.println("Name  : "+employee.getName());
		System.out.println("Address: "+employee.getAddress());
		System.out.println("DOB : "+employee.getDob());
		System.out.println("==================================");
		return employee;
	}
	
	/**
	 * @return
	 */
	//@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();
			
			employee.setName("Munawarman");
			employee.setAddress("Kelapa Dua");
			String stringTanggal = "2019-03-03";
			Date tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(stringTanggal);
			employee.setDob(tanggal);
			
			employeeDAO.save(employee);
			System.out.println("Data berhasil tersimpan");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data gagal di simpan");
			e.printStackTrace();
			return false;
		}
	}
	
	//@Bean
	public boolean update() {
		try {
			Employee employee = new Employee();
			
			
			employee.setId(12);
			employee.setName("robi");
			employee.setAddress("Kelapa Dua");
			String stringTanggal = "2019-03-03";
			Date tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(stringTanggal);
			employee.setDob(tanggal);
			
			employeeDAO.update(employee);
			System.out.println("Data berhasil tersimpan");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data gagal di simpan");
			e.printStackTrace();
			return false;
		}
	}
	//@Bean
	public boolean delete() {
		try {
			employeeDAO.delete(12);
			System.out.println("Data berhasil di hapus");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data gagal di hapus");
			e.printStackTrace();
			return false;
		}
	}
	
	@Bean
	public List<Employee> getByName() {
		List<Employee> employees = employeeDAO.getByName("e");
		
		for (Employee employee : employees) {
		System.out.println("Name  : "+employee.getName());
		}
		return employees;
	}
}
