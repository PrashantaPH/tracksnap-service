package com.tracksnap.api.dto;

import java.sql.Date;

public class SectorsDTO {

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
