package com.tractsnap.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.tractsnap.api.dto.CompaniesDTO;
import com.tractsnap.api.dto.ResponseStructure;
import com.tractsnap.api.service.CompaniesService;

@RestController
@RequestMapping("/api/v1/companies")
public class CompaniesController {

	private static Logger logger = LoggerFactory.getLogger(CompaniesController.class);

	@Autowired
	private CompaniesService companiesService;
	
	private static final String SUCCESS = "Success";

	@PostMapping
	public ResponseEntity<ResponseStructure<CompaniesDTO>> create(@RequestPart("logoImage") MultipartFile logoImage,
			@RequestPart("countryFlagImage") MultipartFile countryFlagImage, @RequestPart("companies") CompaniesDTO companiesDto) {

		logger.info("<-------- Companies Create Request -------->");

		CompaniesDTO createdCompany  = companiesService.createCompany(logoImage, countryFlagImage, companiesDto);

		ResponseStructure<CompaniesDTO> respoStructure = new ResponseStructure<>();
		respoStructure.setStatus(HttpStatus.CREATED.value());
		respoStructure.setMessage(SUCCESS);
		respoStructure.setData(createdCompany );

		return new ResponseEntity<>(respoStructure, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<CompaniesDTO>>> getAllData() {

		logger.info("<-------- Companies getAllData Request -------->");

		List<CompaniesDTO> companiesDtos = companiesService.getAllCompanies();

		ResponseStructure<List<CompaniesDTO>> respoStructure = new ResponseStructure<>();
		respoStructure.setStatus(HttpStatus.OK.value());
		respoStructure.setMessage(SUCCESS);
		respoStructure.setData(companiesDtos);
		return new ResponseEntity<>(respoStructure, HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<CompaniesDTO>> getDataById(@PathVariable("companyId") Long companyId) {

		logger.info("<-------- Companies getDataById Request -------->");

		CompaniesDTO companiesDTO = companiesService.getCompaniesById(companyId);

		ResponseStructure<CompaniesDTO> respoStructure = new ResponseStructure<>();
		respoStructure.setStatus(HttpStatus.OK.value());
		respoStructure.setMessage(SUCCESS);
		respoStructure.setData(companiesDTO);

		return new ResponseEntity<>(respoStructure, HttpStatus.OK);
	}

	@PutMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<CompaniesDTO>> update(@PathVariable("companyId") Long companyId,
			@RequestPart("logoImage") MultipartFile logoImage,
			@RequestPart("countryFlagImage") MultipartFile countryFlagImage,
			@RequestPart("companies") CompaniesDTO companiesDto) {
		
		logger.info("<-------- Companies Update Request -------->");
		
		CompaniesDTO updateCompany = companiesService.updateCompany(companyId, logoImage, countryFlagImage, companiesDto);
		
		ResponseStructure<CompaniesDTO> respoStructure = new ResponseStructure<>();
		respoStructure.setStatus(HttpStatus.OK.value());
		respoStructure.setMessage(SUCCESS);
		respoStructure.setData(updateCompany);

		return new ResponseEntity<>(respoStructure, HttpStatus.OK);
	}
	
	@DeleteMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable("companyId") Long companyId) {
		
		logger.info("<-------- Companies delete Request -------->");
		
		companiesService.deleteCompany(companyId);
		
		ResponseStructure<String> respoStructure = new ResponseStructure<>();
		
		respoStructure.setStatus(HttpStatus.ACCEPTED.value());
		respoStructure.setMessage(SUCCESS);
		respoStructure.setData("Companies ID :"+companyId+" deleted successfully...!");
		
		return new ResponseEntity<>(respoStructure, HttpStatus.ACCEPTED);
	}
}
