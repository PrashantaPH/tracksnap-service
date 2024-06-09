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
@Table(name = "sectors")
@DynamicInsert
@DynamicUpdate
public class Sectors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sectors_id")
	private Long sectorsId;

	private String name;

	private Date createdAt;

	private Date updatedAt;

	public Long getSectorsId() {
		return sectorsId;
	}

	public void setSectorsId(Long sectorsId) {
		this.sectorsId = sectorsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
