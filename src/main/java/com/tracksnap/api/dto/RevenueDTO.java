package com.tracksnap.api.dto;

import java.sql.Date;

public class RevenueDTO {

	private Long revenueId;

	private String fiscalYear;

	private String revenue;

	private Date createdAt;

	private Date updatedAt;

	public Long getRevenueId() {
		return revenueId;
	}

	public void setRevenueId(Long revenueId) {
		this.revenueId = revenueId;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
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
