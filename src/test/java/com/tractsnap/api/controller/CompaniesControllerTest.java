package com.tractsnap.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tractsnap.api.dto.CompaniesDTO;
import com.tractsnap.api.dto.KeyMatricesDTO;
import com.tractsnap.api.dto.ResponseStructure;
import com.tractsnap.api.service.CompaniesService;

class CompaniesControllerTest {

	@Mock
	private CompaniesService companiesService;

	@InjectMocks
	private CompaniesController companiesController;
	
	private static final Long COMPANYID = 1l;

	private static final String SUCCESS = "Success";

	private static final String CNAME = "Test Company Ltd";

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	CompaniesDTO getCompaniesDtoObject() {
		KeyMatricesDTO keyMatricesDto = new KeyMatricesDTO();
		keyMatricesDto.setAnnualRevenue("Test A");
		keyMatricesDto.setAnnualRevenue("$100");
		keyMatricesDto.setEmployeeCount(250);

		CompaniesDTO companiesDto = new CompaniesDTO();
		companiesDto.setName(CNAME);
		companiesDto.setFoundedYear(2008);
		companiesDto.setHeadquarterCity("New Yark");
		companiesDto.setEmail("test@tracxn.com");
		companiesDto.setPhone("91-64637-67322");
		companiesDto.setFacebookUrl("https://test.com");
		companiesDto.setInstagramUrl("https://test.com");
		companiesDto.setLinkedInUrl("https://test.com");
		companiesDto.setTwitterUrl("https://test.com");
		companiesDto.setKeyMatricesDTO(keyMatricesDto);

		return companiesDto;
	}

	@Test
	void createTest() {
		CompaniesDTO companiesDto = getCompaniesDtoObject();

		when(companiesService.createCompany(null, null, companiesDto)).thenReturn(companiesDto);

		ResponseEntity<ResponseStructure<CompaniesDTO>> responseEntity = companiesController.create(null, null, companiesDto);

		ResponseStructure<CompaniesDTO> responseStructure = responseEntity.getBody();

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(HttpStatus.CREATED.value(), responseStructure.getStatus());
		assertEquals(SUCCESS, responseStructure.getMessage());
		assertEquals(CNAME, responseStructure.getData().getName());

	}

	@Test
	void getAllDataTest() {
		CompaniesDTO companiesDTO = getCompaniesDtoObject();
		List<CompaniesDTO> list = Arrays.asList(companiesDTO);

		when(companiesService.getAllCompanies()).thenReturn(list);

		ResponseEntity<ResponseStructure<List<CompaniesDTO>>> responseEntity = companiesController.getAllData();

		ResponseStructure<List<CompaniesDTO>> responseStructure = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(HttpStatus.OK.value(), responseStructure.getStatus());
		assertEquals(SUCCESS, responseStructure.getMessage());
		assertEquals(CNAME, responseStructure.getData().get(0).getName());

	}

	@Test
	void getDataByIdTest() {
		CompaniesDTO companiesDTO = getCompaniesDtoObject();

		when(companiesService.getCompaniesById(COMPANYID)).thenReturn(companiesDTO);

		ResponseEntity<ResponseStructure<CompaniesDTO>> responseEntity = companiesController.getDataById(COMPANYID);

		ResponseStructure<CompaniesDTO> responseStructure = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(HttpStatus.OK.value(), responseStructure.getStatus());
		assertEquals(SUCCESS, responseStructure.getMessage());
		assertEquals(CNAME, responseStructure.getData().getName());
	}
	
	@Test
	void updateTest() {
		CompaniesDTO companiesDto = getCompaniesDtoObject();

		when(companiesService.updateCompany(COMPANYID, null, null, companiesDto)).thenReturn(companiesDto);

		ResponseEntity<ResponseStructure<CompaniesDTO>> responseEntity = companiesController.update(COMPANYID, null, null, companiesDto);

		ResponseStructure<CompaniesDTO> responseStructure = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(HttpStatus.OK.value(), responseStructure.getStatus());
		assertEquals(SUCCESS, responseStructure.getMessage());
		assertEquals(CNAME, responseStructure.getData().getName());

	}

	@Test
	void deleteTest() {
		String deleteMsg = "Companies ID :" + COMPANYID + " deleted successfully...!";

		doNothing().when(companiesService).deleteCompany(COMPANYID);

		ResponseEntity<ResponseStructure<String>> responseEntity = companiesController.delete(COMPANYID);

		ResponseStructure<String> responseStructure = responseEntity.getBody();

		assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
		assertEquals(HttpStatus.ACCEPTED.value(), responseStructure.getStatus());
		assertEquals(SUCCESS, responseStructure.getMessage());
		assertEquals(deleteMsg, responseStructure.getData());

	}

}
