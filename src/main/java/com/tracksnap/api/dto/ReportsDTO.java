package com.tracksnap.api.dto;

import java.sql.Date;

public class ReportsDTO {

	private Long reportId;

	private String fiscalYear;

	private String reportPdfUrl;

	private Date createdAt;

	private Date updatedAt;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getReportPdfUrl() {
		return reportPdfUrl;
	}

	public void setReportPdfUrl(String reportPdfUrl) {
		this.reportPdfUrl = reportPdfUrl;
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
