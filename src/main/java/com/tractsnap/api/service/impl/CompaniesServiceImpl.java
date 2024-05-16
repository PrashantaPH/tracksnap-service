package com.tractsnap.api.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tractsnap.api.dto.CompaniesDTO;
import com.tractsnap.api.dto.KeyMatricesDTO;
import com.tractsnap.api.entity.Companies;
import com.tractsnap.api.entity.KeyMatrices;
import com.tractsnap.api.exception.ResourceNotFoundException;
import com.tractsnap.api.mapper.CompaniesMapper;
import com.tractsnap.api.repository.CompaniesRepository;
import com.tractsnap.api.service.CompaniesService;

@Service
public class CompaniesServiceImpl implements CompaniesService {

	private static Logger logger = LoggerFactory.getLogger(CompaniesServiceImpl.class);

	@Autowired
	private CompaniesMapper companiesMapper;

	@Autowired
	private CompaniesRepository companiesRepository;

	@Override
	public CompaniesDTO createCompany(MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO companiesDto) {
	    Companies companies = companiesMapper.dtoToEntity(companiesDto);
	    try {
	        companies.setLogoImage(logoImage.getBytes());
	        companies.setcountryFlagImage(countryFlagImage.getBytes());
	    } catch (IOException e) {
	        logger.error("Exception occurred -> {}", e.getMessage(), e);
	    }
	    companiesRepository.save(companies);

	    return companiesMapper.entityToDto(companies);
	}

	@Override
	public List<CompaniesDTO> getAllCompanies() {
		List<Companies> companies = companiesRepository.findAll();

		if (companies.size() == 0) {
			throw new ResourceNotFoundException("Companies not avalable " + companies.size());
		}
		return companiesMapper.entityToDtoList(companies);
	}

	@Override
	public CompaniesDTO getCompaniesById(Long companyId) {
		Optional<Companies> optional = companiesRepository.findById(companyId);

		if (optional.isEmpty()) {
			logger.error("Companies given ID : {} is not available...!", companyId);
			throw new ResourceNotFoundException("Companies given ID : " + companyId + " not avalable...!");
		}
		return companiesMapper.entityToDto(optional.get());
	}

	@Override
	public CompaniesDTO updateCompany(Long companyId, MultipartFile logoImage, MultipartFile countryFlagImage, CompaniesDTO updatecompaniesDtoObj) {
	    Optional<Companies> optional = companiesRepository.findById(companyId);
	    if (optional.isEmpty()) {
	        logger.error("Companies with ID : {} is not available...!", companyId);
	        throw new ResourceNotFoundException("Companies with ID : " + companyId + " not available...!");
	    }
		try {
			if (logoImage != null) {
				updatecompaniesDtoObj.setLogoImage(logoImage.getBytes());
			}
			if(countryFlagImage != null) {
				updatecompaniesDtoObj.setCountryFlagImage(countryFlagImage.getBytes());
			}
		} catch (IOException e) {
			logger.error("Exception occurred -> {}", e.getMessage(), e);
		}

	    Companies existingCompany = optional.get();
	    dtoToEntityUpdate(existingCompany, updatecompaniesDtoObj);

	    Companies updatedData = companiesRepository.save(existingCompany);

	    return companiesMapper.entityToDto(updatedData);
	}

	@Override
	public void deleteCompany(Long companyId) {
		Companies companies = companiesRepository.findById(companyId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Companies is not exists with the given id : " + companyId));

		companiesRepository.delete(companies);
	}
	
	private void dtoToEntityUpdate(Companies existingCompany, CompaniesDTO updatecompaniesDtoObj) {
//	    // Update Company properties
	    existingCompany.setName(updatecompaniesDtoObj.getName());
	    existingCompany.setFoundedYear(updatecompaniesDtoObj.getFoundedYear());
	    existingCompany.setHeadquarterCity(updatecompaniesDtoObj.getHeadquarterCity());
	    existingCompany.setWebsite(updatecompaniesDtoObj.getWebsite());
	    existingCompany.setPhone(updatecompaniesDtoObj.getPhone());
	    existingCompany.setEmail(updatecompaniesDtoObj.getEmail());
	    existingCompany.setFacebookUrl(updatecompaniesDtoObj.getFacebookUrl());
	    existingCompany.setTwitterUrl(updatecompaniesDtoObj.getTwitterUrl());
	    existingCompany.setLinkedInUrl(updatecompaniesDtoObj.getLinkedInUrl());
	    existingCompany.setInstagramUrl(updatecompaniesDtoObj.getInstagramUrl());
	    byte[] logoImage = updatecompaniesDtoObj.getLogoImage();
        if ( logoImage != null ) {
        	existingCompany.setLogoImage( Arrays.copyOf( logoImage, logoImage.length ) );
        }
        else {
        	existingCompany.setLogoImage( null );
        }

//	    // Update KeyMatrices properties
	    KeyMatricesDTO updateKeyMatricesDto = updatecompaniesDtoObj.getKeyMatricesDTO();
	    KeyMatrices existingKeyMatrices = existingCompany.getKeyMatrices();
	    existingKeyMatrices.setLatestFundingRound(updateKeyMatricesDto.getLatestFundingRound());
	    existingKeyMatrices.setAnnualRevenue(updateKeyMatricesDto.getAnnualRevenue());
	    existingKeyMatrices.setEmployeeCount(updateKeyMatricesDto.getEmployeeCount());
    }

}
