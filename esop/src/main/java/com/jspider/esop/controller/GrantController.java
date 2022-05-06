package com.jspider.esop.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jspider.esop.constant.AppConstant;
import com.jspider.esop.dto.GrantDto;
import com.jspider.esop.entity.Grant;
import com.jspider.esop.service.GrantService;

@Controller
@RestController
@RequestMapping(value=AppConstant.COMMON_CONTROLLER)
public class GrantController {


	@Autowired
	private GrantService grantService;
	

	@PostMapping(value = AppConstant.PREPARE_AND_UPLOAD_GRANTS)
	public void prepareAndUploadGrants(@RequestBody List<GrantDto> list) {
		System.out.println(list);
		grantService.prepareAndUploadGrants(list);
	}

	@PostMapping(value = AppConstant.UPDATE_GRANTS_Allocation)
	public void updateGrantStatus(@RequestBody String grantNumber) {
		Grant grant = new Grant();
		grantService.updateGrantAllocationStatus(grantNumber);
	}
}
