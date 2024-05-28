package com.tracksnap.api.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "key_matrices")
@DynamicInsert
@DynamicUpdate
public class KeyMatrices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "key_matrices_id")
	private Long keyMatricesId;

	@Column(name = "latest_funding_round")
	private String latestFundingRound;

	@Column(name = "annual_revenue")
	private String annualRevenue;

	@Column(name = "employee_count")
	private int employeeCount;

	public KeyMatrices() {
		super();
	}

	public KeyMatrices(String latestFundingRound, String annualRevenue, int employeeCount) {
		super();
		this.latestFundingRound = latestFundingRound;
		this.annualRevenue = annualRevenue;
		this.employeeCount = employeeCount;
	}

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
