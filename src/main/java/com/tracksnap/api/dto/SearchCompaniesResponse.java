package com.tracksnap.api.dto;

public class SearchCompaniesResponse {

	private Long companyId;

	private String name;

	private byte[] logoImage;

	private int foundedYear;

	private String headquarterCity;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(byte[] logoImage) {
		this.logoImage = logoImage;
	}

	public int getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(int foundedYear) {
		this.foundedYear = foundedYear;
	}

	public String getHeadquarterCity() {
		return headquarterCity;
	}

	public void setHeadquarterCity(String headquarterCity) {
		this.headquarterCity = headquarterCity;
	}

}
