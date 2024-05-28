package com.tracksnap.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompaniesDTO {

	private Long companyId;

	private String name;

	private byte[] logoImage;

	private int foundedYear;

	private String headquarterCity;

	private byte[] countryFlagImage;

	private String website;

	private String phone;

	private String email;

	private String facebookUrl;

	private String twitterUrl;

	private String linkedInUrl;

	private String instagramUrl;

	@JsonProperty("keyMatrices")
	private KeyMatricesDTO keyMatricesDTO;

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

}
