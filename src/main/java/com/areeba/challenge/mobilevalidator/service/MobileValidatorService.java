package com.areeba.challenge.mobilevalidator.service;

import java.text.MessageFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.areeba.challenge.mobilevalidator.dto.MobileDetailDTO;

/**
 * Service Layer class that read validate and return detials of mobileNumber using apilayer API
 * @author Hussein Zaraket
 *
 */
@Service
public class MobileValidatorService {

	// access key value set in application.properties file in order to access the needed API
	@Value("${api.validator.key}")
	private String apiAccessKey;
	
	// api url value set in application.properties file in order to use it to validate the and retrieve details about specific mobile number 
	@Value("${api.validator.url}")
	private String apiUrl;
	
	/**
	 * Method that retrieve data about a specific mobile number and fill it in a MobileDetailDTO class
	 * @param mobile
	 * @return
	 */
	public MobileDetailDTO returnMobileDetail(String mobile) 
	{
		RestTemplate restTemplate = new RestTemplate();
		// call the specified url using the valid accesskey and retrieve detials related to a specific number
		HashMap<String, Object> result = restTemplate.getForObject(MessageFormat.format(apiUrl, apiAccessKey, mobile), HashMap.class);
		boolean valid = (boolean)result.get("valid"); 
		MobileDetailDTO mobileDetailDTO = new MobileDetailDTO();
		
		// if number not valid the a message error
		if(!valid) 
		{
			mobileDetailDTO.setMessage("Invalid number");
		}
		// if valid retrieve the needed detials
		else 
		{
			mobileDetailDTO.setCountryCode((String)result.get("country_code"));
			mobileDetailDTO.setCountryName((String)result.get("country_name"));
			mobileDetailDTO.setOperatorName((String)result.get("carrier"));
		}
		mobileDetailDTO.setValid(valid);
		return mobileDetailDTO;
	}
	
}