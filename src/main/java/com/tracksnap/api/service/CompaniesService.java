package com.tracksnap.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracksnap.api.dto.CompaniesDTO;

public interface CompaniesService {

	public CompaniesDTO createCompany(MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDTO);
	
	public List<CompaniesDTO> getAllCompanies();
	
	public CompaniesDTO getCompaniesById(Long companyId);
	
	public CompaniesDTO updateCompany(Long companyId, MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDTO);
	
	public void deleteCompany(Long companyId);
}
