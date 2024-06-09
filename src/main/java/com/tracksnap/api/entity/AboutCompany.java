package com.tracksnap.api.entity;

import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "about_company")
@DynamicInsert
@DynamicUpdate
public class AboutCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "about_comapny_id")
	private Long aboutComapnyId;

	@Column(name = "about_company")
	private String aboutCompany;

	@Column(length = 1048576)
	@Lob
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
