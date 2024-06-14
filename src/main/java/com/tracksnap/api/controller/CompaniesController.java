package com.tracksnap.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tracksnap.api.dto.CompaniesDTO;
import com.tracksnap.api.dto.ResponseStructure;
import com.tracksnap.api.dto.SearchCompaniesResponse;
import com.tracksnap.api.service.CompaniesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/companies")
@CrossOrigin("*")
public class CompaniesController {

	private static Logger logger = LoggerFactory.getLogger(CompaniesController.class);

	private CompaniesService companiesService;

	public CompaniesController(CompaniesService companiesService) {
		this.companiesService = companiesService;
	}

	@PostMapping
	public ResponseEntity<ResponseStructure<CompaniesDTO>> create(@RequestPart("logoImage") MultipartFile logoImage,
			@RequestPart("countryFlagImage") MultipartFile countryFlagImage,
			@Valid @RequestPart("companies") CompaniesDTO companiesDto) {

		logger.info("<-------- Companies Create Request -------->");

		CompaniesDTO createdCompany = companiesService.createCompany(logoImage, countryFlagImage, companiesDto);

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

		CompaniesDTO updateCompany = companiesService.updateCompany(companyId, logoImage, countryFlagImage,
				companiesDto);

		return ResponseStructure.ok(updateCompany);
	}

	@DeleteMapping("/{companyId}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable("companyId") Long companyId) {

		logger.info("<-------- Companies delete Request -------->");

		companiesService.deleteCompany(companyId);

		return ResponseStructure.accepted("Companies ID :" + companyId + " deleted successfully...!");
	}

	@GetMapping("/download-logoimage/{companyId}")
	public ResponseEntity<ResponseStructure<String>> downloadLogoImage(@PathVariable("companyId") Long companyId) {

		logger.info("<-------- Companies LogoImage download Request -------->");

		companiesService.downloadLogoImageByCompanyId(companyId);

		return ResponseStructure.ok("Image downloaded successfully in downloads folder.");
	}

	@GetMapping("/logo-image/{companyId}")
	public ResponseEntity<ResponseStructure<byte[]>> getLogoImage(@PathVariable("companyId") Long companyId) {

		logger.info("<-------- Companies getLogoImage Request -------->");

		byte[] byteArr = companiesService.getLogoImageByCompanyId(companyId);

		return ResponseStructure.ok(byteArr);
	}

	@GetMapping("/count-record")
	public ResponseEntity<ResponseStructure<Long>> getCount() {

		logger.info("<-------- Companies countOfRecord Request -------->");

		Long count = companiesService.getCountOfRecord();

		return ResponseStructure.ok(count);
	}

	@GetMapping("/get-companyIds")
	public ResponseEntity<ResponseStructure<List<Long>>> getAllId() {

		logger.info("<-------- Companies getAllId Request -------->");

		List<Long> ids = companiesService.getAllCompanyId();

		return ResponseStructure.ok(ids);
	}
	
	@GetMapping("/search-getall")
	public ResponseEntity<ResponseStructure<List<CompaniesDTO>>> findAll(@RequestParam("name") String name) {

		logger.info("<-------- Companies serach Request -------->");

		List<CompaniesDTO> list = companiesService.findByCompanyName(name);

		return ResponseStructure.ok(list);
	}

	@GetMapping("/search")
	public ResponseEntity<ResponseStructure<List<SearchCompaniesResponse>>> serach(@RequestParam("name") String name) {

		logger.info("<-------- Companies serach Request -------->");

		List<SearchCompaniesResponse> list = companiesService.searchByCompanyName(name);

		return ResponseStructure.ok(list);
	}

}
