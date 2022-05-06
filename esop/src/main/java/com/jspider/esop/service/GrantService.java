package com.jspider.esop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.esop.dto.GrantDto;
import com.jspider.esop.entity.Allocation;
import com.jspider.esop.entity.Employee;
import com.jspider.esop.entity.Grant;
import com.jspider.esop.repository.AllocationGrantRepository;
import com.jspider.esop.repository.GrantRepository;

@Service
public class GrantService {
	
	@Autowired
	private  GrantRepository grantRepository;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AllocationGrantRepository allocationGrantRepository;
	
	
		public Grant getGrantByNumber(String grantNumber) {
				
				return grantRepository.findByGrantNumber(grantNumber);
			
			}

	
	public void prepareAndUploadGrants(List<GrantDto> list) {
		List<Grant> grantlist = new ArrayList<Grant>();
		list.forEach(each->{
			Grant grant=new Grant();
			grant.setGrantNumber(each.getGrantNumber());
			grant.setAccepted(each.isAccepted());
			grant.setAcceptedDate(each.getAcceptedDate());
			grant.setEmployee(commonService.getEmployeeByName(each.getEmployee()));
			grant.setGrantDate(each.getGrantDate());
			grant.setGrantedBy(commonService.getEmployeeByName(each.getGrantedBy()));
			grant.setGrantStatus(each.getGrantStatus());
			grant.setPlan(commonService.getPlanByYear(each.getPlan()));
			grant.setNoOfGrants(each.getNoOfGrants());
			grantlist.add(grant);
		});
		grantRepository.saveAll(grantlist);
	}




	public void updateGrantAllocationStatus(String grantNumber) {
		
		Allocation allocation = new Allocation();
		Grant grant = getGrantByNumber(grantNumber);
		grant.setAccepted(true);
		grant.setAcceptedDate(new Date());
		Employee employee = grant.getEmployee();
		String bond = employee.getBond();
		int parseIntBond = Integer.parseInt(bond);
		if(parseIntBond<5) {
			allocation.setAllocateGrantNumber(Long.parseLong(grant.getNoOfGrants()));
			allocation.setGrant(grant);
		}
		else {
			String noOfGrants = grant.getNoOfGrants();
			 Long grantCount = Long.parseLong(noOfGrants);
			 Long yearGrant=grantCount/5;
			 allocation.setAllocateGrantNumber(yearGrant);
			 allocation.setGrant(grant);
		}
		allocation.setAllocateGrantYear("2023");
		allocation.setAllocateGrantStatus("pending");
		allocation.setAllocateGrantDate(new Date());
		allocation.setGrant(grant);
		allocationGrantRepository.save(allocation);
	}	
		
}




