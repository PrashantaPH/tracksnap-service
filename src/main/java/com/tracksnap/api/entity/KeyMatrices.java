package com.tracksnap.api.entity;

import java.sql.Date;

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
