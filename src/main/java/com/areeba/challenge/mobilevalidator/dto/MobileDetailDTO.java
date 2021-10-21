package com.areeba.challenge.mobilevalidator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Data Transfer Object to transfer data via webservice
 * @author Hussein Zaraket
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class MobileDetailDTO {

	private boolean valid;
	private String countryCode;
	private String countryName;
	private String operatorName;
	private String message;

	public MobileDetailDTO() {

	}

	public MobileDetailDTO(boolean valid, String countryCode, String countryName, String operatorName, String message) {
		this.valid = valid;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.operatorName = operatorName;
		this.message = message;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MobileNumberDTO [valid=" + valid + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", operatorName=" + operatorName + "]";
	}

}
