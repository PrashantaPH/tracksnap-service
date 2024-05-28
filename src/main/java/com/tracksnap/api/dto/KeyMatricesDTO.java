package com.tracksnap.api.dto;

public class KeyMatricesDTO {

	private Long keyMatricesId;

	private String latestFundingRound;

	private String annualRevenue;

	private int employeeCount;

	public Long getKeyMatricesId() {
		return keyMatricesId;
	}

	public void setKeyMatricesId(Long keyMatricesId) {
		this.keyMatricesId = keyMatricesId;
	}

	public String getLatestFundingRound() {
		return latestFundingRound;
	}

	public void setLatestFundingRound(String latestFundingRound) {
		this.latestFundingRound = latestFundingRound;
	}

	public String getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

}
