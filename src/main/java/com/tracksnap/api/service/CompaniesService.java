package com.tracksnap.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracksnap.api.dto.CompaniesDTO;
import com.tracksnap.api.dto.SearchCompaniesResponse;

public interface CompaniesService {

	CompaniesDTO createCompany(MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDTO);
	
	List<CompaniesDTO> getAllCompanies();
	
	CompaniesDTO getCompaniesById(Long companyId);
	
	CompaniesDTO updateCompany(Long companyId, MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDTO);
	
	void deleteCompany(Long companyId);
	
	void downloadLogoImageByCompanyId(Long companyId);
	
	byte[] getLogoImageByCompanyId(Long companyId);
	
	Long getCountOfRecord();
	
	List<Long> getAllCompanyId();
	
	List<CompaniesDTO> findByCompanyName(String name);
	
	List<SearchCompaniesResponse> searchByCompanyName(String name);
}
