package com.tracksnap.api.dto;

import java.sql.Date;

public class KeyMatricesDTO {

	private Long keyMatricesId;

	private String latestFundingRound;

	private String annualRevenue;

	private int employeeCount;

	private Date createdAt;

	private Date updatedAt;

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
