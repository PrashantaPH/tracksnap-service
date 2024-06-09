package com.tracksnap.api.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class CompaniesDTO {

	private Long companyId;

	@NotNull(message = "Name is required")
	private String name;

	private byte[] logoImage;

	private int foundedYear;

	private String headquarterCity;

	private byte[] countryFlagImage;

	private String website;

	private String phone;

	@NotNull(message = "Email is required")
	private String email;

	private Date createdAt;

	private Date updatedAt;

	private String facebookUrl;

	private String twitterUrl;

	private String linkedInUrl;

	private String instagramUrl;

	@JsonProperty("keyMatrices")
	private KeyMatricesDTO keyMatricesDTO;

	@JsonProperty("aboutComapany")
	private AboutCompanyDTO aboutCompanyDTO;

	@JsonProperty("sectors")
	private SectorsDTO sectorsDTO;

	@JsonProperty("people")
	private PeopleDTO peopleDTO;

	@JsonProperty("revenue")
	private RevenueDTO revenueDTO;

	@JsonProperty("reports")
	private ReportsDTO reportsDTO;

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

	public byte[] getCountryFlagImage() {
		return countryFlagImage;
	}

	public void setCountryFlagImage(byte[] countryFlagImage) {
		this.countryFlagImage = countryFlagImage;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public KeyMatricesDTO getKeyMatricesDTO() {
		return keyMatricesDTO;
	}

	public void setKeyMatricesDTO(KeyMatricesDTO keyMatricesDTO) {
		this.keyMatricesDTO = keyMatricesDTO;
	}

	public AboutCompanyDTO getAboutCompanyDTO() {
		return aboutCompanyDTO;
	}

	public void setAboutCompanyDTO(AboutCompanyDTO aboutCompanyDTO) {
		this.aboutCompanyDTO = aboutCompanyDTO;
	}

	public SectorsDTO getSectorsDTO() {
		return sectorsDTO;
	}

	public void setSectorsDTO(SectorsDTO sectorsDTO) {
		this.sectorsDTO = sectorsDTO;
	}

	public PeopleDTO getPeopleDTO() {
		return peopleDTO;
	}

	public void setPeopleDTO(PeopleDTO peopleDTO) {
		this.peopleDTO = peopleDTO;
	}

	public RevenueDTO getRevenueDTO() {
		return revenueDTO;
	}

	public void setRevenueDTO(RevenueDTO revenueDTO) {
		this.revenueDTO = revenueDTO;
	}

	public ReportsDTO getReportsDTO() {
		return reportsDTO;
	}

	public void setReportsDTO(ReportsDTO reportsDTO) {
		this.reportsDTO = reportsDTO;
	}

}
