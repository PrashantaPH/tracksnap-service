package com.tracksnap.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tracksnap.api.dto.CompaniesDTO;
import com.tracksnap.api.dto.ResponseStructure;
import com.tracksnap.api.service.CompaniesService;

@RestController
@RequestMapping("/api/v1/companies")
public class CompaniesController {

	private static Logger logger = LoggerFactory.getLogger(CompaniesController.class);

	private CompaniesService companiesService;
	
	public CompaniesController(CompaniesService companiesService){
		this.companiesService = companiesService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CompaniesDTO>> create(@RequestPart("logoImage") MultipartFile logoImage,
			@RequestPart("countryFlagImage") MultipartFile countryFlagImage,
			@RequestPart("companies") CompaniesDTO companiesDto) {

		logger.info("<-------- Companies Create Request -------->");

		CompaniesDTO createdCompany  = companiesService.createCompany(logoImage, countryFlagImage, companiesDto);

		return ResponseStructure.created(createdCompany);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<CompaniesDTO>>> getAllData() {

		logger.info("<-------- Companies getAllData Request -------->");

		List<CompaniesDTO> companiesDtos = companiesService.getAllCompanies();

		return ResponseStructure.ok(companiesDtos);
	}

	@GetMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<CompaniesDTO>> getDataById(@PathVariable("companyId") Long companyId) {

		logger.info("<-------- Companies getDataById Request -------->");

		CompaniesDTO companiesDTO = companiesService.getCompaniesById(companyId);

		return ResponseStructure.ok(companiesDTO);
	}

	@PutMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<CompaniesDTO>> update(@PathVariable("companyId") Long companyId,
			@RequestPart("logoImage") MultipartFile logoImage,
			@RequestPart("countryFlagImage") MultipartFile countryFlagImage,
			@RequestPart("companies") CompaniesDTO companiesDto) {
		
		logger.info("<-------- Companies Update Request -------->");
		
		CompaniesDTO updateCompany = companiesService.updateCompany(companyId, logoImage, countryFlagImage, companiesDto);
		
		return ResponseStructure.ok(updateCompany);
	}
	
	@DeleteMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable("companyId") Long companyId) {
		
		logger.info("<-------- Companies delete Request -------->");
		
		companiesService.deleteCompany(companyId);
		
		return ResponseStructure.accepted(companyId);
	}
}
