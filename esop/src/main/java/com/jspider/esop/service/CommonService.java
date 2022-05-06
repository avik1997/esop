package com.jspider.esop.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.esop.entity.Employee;
import com.jspider.esop.entity.Plan;
import com.jspider.esop.repository.EmployeeRepository;
import com.jspider.esop.repository.PlanRepository;

@Service
public class CommonService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PlanRepository planRepository;
	
	/*
	 * 
	 */
	public Employee getEmployeeByName(String name) {
		
		return	employeeRepository.findByName(name);
			
	}
	
	/*
	 * 
	 */
	public Optional<Plan> getPlanById(Long id) {
	   return planRepository.findById(id);
	}
	
	/*
	 * 
	 */
	public Plan getPlanByYear(String planYear) {
		return planRepository.findByYear(planYear);
	}
	
	/*
	 * 
	 */
	public void savePlan(Plan plan)
	{
		planRepository.save(plan);
	}
	
	/*
	 * 
	 */
	public void saveEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}


	
	
}
