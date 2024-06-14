package com.tracksnap.api.entity;

import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
@DynamicInsert
@DynamicUpdate
public class Companies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyId;

	@Column(nullable = false)
	private String name;

	@Column(name = "logo_image", length = 1048576)
	@Lob
	private byte[] logoImage;

	@Column(name = "founded_year")
	private int foundedYear;

	@Column(name = "headquarter_city")
	private String headquarterCity;

	@Column(name = "country_flag_image", length = 1048576)
	@Lob
	private byte[] countryFlagImage;

	private String website;

	private String phone;

	private String email;

	private Date createdAt;

	private Date updatedAt;

	@Column(name = "facebook_url")
	private String facebookUrl;

	@Column(name = "twitter_url")
	private String twitterUrl;

	@Column(name = "linkedIn_url")
	private String linkedInUrl;

	@Column(name = "instagram_url")
	private String instagramUrl;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_key_matrices_id")
	private KeyMatrices keyMatrices;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_about_comapny_id")
	private AboutCompany aboutCompany;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_sectors_id")
	private Sectors sectors;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_people_id")
	private People people;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_revenue_id")
	private Revenue revenue;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_reports_id")
	private Reports reports;

	public Companies() {
		super();
	}

	public Companies(Long companyId, String name, int foundedYear,  String headquarterCity, byte[] logoImage) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.foundedYear = foundedYear;
		this.headquarterCity = headquarterCity;
		this.logoImage = logoImage;
	}

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

	public KeyMatrices getKeyMatrices() {
		return keyMatrices;
	}

	public void setKeyMatrices(KeyMatrices keyMatrices) {
		this.keyMatrices = keyMatrices;
	}

	public AboutCompany getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(AboutCompany aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public Sectors getSectors() {
		return sectors;
	}

	public void setSectors(Sectors sectors) {
		this.sectors = sectors;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Revenue getRevenue() {
		return revenue;
	}

	public void setRevenue(Revenue revenue) {
		this.revenue = revenue;
	}

	public Reports getReports() {
		return reports;
	}

	public void setReports(Reports reports) {
		this.reports = reports;
	}

}
