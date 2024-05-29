package com.tracksnap.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracksnap.api.dto.CompaniesDTO;

public interface CompaniesService {

	CompaniesDTO createCompany(MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDTO);
	
	List<CompaniesDTO> getAllCompanies();
	
	CompaniesDTO getCompaniesById(Long companyId);
	
	CompaniesDTO updateCompany(Long companyId, MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDTO);
	
	void deleteCompany(Long companyId);
	
	void downloadLogoImageByCompanyId(Long companyId);
	
	byte[] getLogoImageByCompanyId(Long companyId);
}
