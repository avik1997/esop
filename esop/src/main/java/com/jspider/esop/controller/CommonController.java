package com.jspider.esop.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jspider.esop.constant.AppConstant;
import com.jspider.esop.entity.Employee;
import com.jspider.esop.entity.Plan;
import com.jspider.esop.service.CommonService;

@Controller
@RestController
@RequestMapping(value=AppConstant.COMMON_CONTROLLER)
public class CommonController {

	@Autowired
	private CommonService commonService;
	
	/*
	 *
	 */
//	@GetMapping(value = AppConstant.GET_EMPLOYEE_BY_NAME)
//	public @ResponseBody Employee getEmployeeByName(String name) {
//		
//		return commonService.getEmployeeByName(name);
//	}
//	
//	@GetMapping(value = AppConstant.GET_PLAN_BY_ID)
//	public @ResponseBody Optional<Plan> getPlanById(Long id) {
//		return commonService.getPlanById(id);
//	}
//	
//	@GetMapping(value = AppConstant.GET_PLAN_BY_YEAR)
//	public @ResponseBody Plan getPlanByYear(String planYear) {
//		return commonService.getPlanByYear(planYear);
//	}
	
	@PostMapping(value=AppConstant.SAVE_PLAN_DETAILS)
	public void savePlan(@RequestBody Plan plan)
	{
		commonService.savePlan(plan);
	}
	
	@PostMapping(value=AppConstant.SAVE_EMPLOYEE_DETAILS)
	public void saveEmployee(@RequestBody Employee employee)
	{
		commonService.saveEmployee(employee);
	}
	
	
}
