package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Account;
import com.learning.entity.Beneficiary;
import com.learning.entity.User;
import com.learning.repo.BeneficiaryRepo;

@RequestMapping("/api/staff")
@RestController
public class StaffController {
	
	@Autowired
	BeneficiaryRepo beneficiaryRepo;
	
	
	
	//Third Method 
	//PUT("/api/staff/beneficiary)
	
	@PutMapping("/beneficiary")
	public ResponseEntity<Beneficiary> approveBeneficiary(@PathVariable("id") long id, @RequestBody Beneficiary beneficiary){
		Beneficiary updateBeneficiary = beneficiaryRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("not found")); 
		
		updateBeneficiary.setapproved(beneficiary.getapproved()); 
		
		beneficiaryRepo.save(updateBeneficiary);
		return ResponseEntity.ok(updateBeneficiary); 
		
		
	}
	
	//Fouth Method 
	//Get("/api/staff/accounts/approve")
	@GetMapping("/accounts/approve")
	  List<Beneficiary> beneficiarytoApprove(){
		
	   	 return beneficiaryRepo.beneficiaryNotApproved();
	   	 
	    }
	
	
	

}
