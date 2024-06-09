package com.tracksnap.api.dto;

import java.sql.Date;

public class AboutCompanyDTO {

	private Long aboutComapnyId;

	private String aboutCompany;

	private byte[] sreenshort;

	private Date createdAt;

	private Date updatedAt;

	public Long getAboutComapnyId() {
		return aboutComapnyId;
	}

	public void setAboutComapnyId(Long aboutComapnyId) {
		this.aboutComapnyId = aboutComapnyId;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public byte[] getSreenshort() {
		return sreenshort;
	}

	public void setSreenshort(byte[] sreenshort) {
		this.sreenshort = sreenshort;
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
