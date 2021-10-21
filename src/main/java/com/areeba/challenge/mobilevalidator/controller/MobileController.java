package com.areeba.challenge.mobilevalidator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.areeba.challenge.mobilevalidator.dto.MobileDetailDTO;
import com.areeba.challenge.mobilevalidator.service.MobileValidatorService;

/**
 * Controller that return details about specific mobile number if valid, else return error message
 * 
 * @author Hussein Zaraket
 */
@CrossOrigin
@RestController
@RequestMapping("/api/mobile-service")
public class MobileController {

	// Inject the needed service to use it below
	@Autowired
	MobileValidatorService validatorService;

	/**
	 * API that receive a mobile number, check if valid to return it's details
	 * @param mobileNumber
	 * @return
	 */
	@GetMapping("/mobileDetails/{number}")
	public ResponseEntity<MobileDetailDTO> returnMobileDetail(@PathVariable("number") String mobileNumber) {
		// call the service layer and get the needed detials
		MobileDetailDTO mobileDetailDTO = validatorService.returnMobileDetail(mobileNumber);
		return new ResponseEntity<>(mobileDetailDTO, HttpStatus.OK);
	}
	
}
