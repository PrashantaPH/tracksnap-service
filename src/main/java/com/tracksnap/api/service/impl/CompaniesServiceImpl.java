package com.tracksnap.api.service.impl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVWriter;
import com.tracksnap.api.dto.CompaniesDTO;
import com.tracksnap.api.dto.KeyMatricesDTO;
import com.tracksnap.api.entity.Companies;
import com.tracksnap.api.entity.KeyMatrices;
import com.tracksnap.api.exception.ResourceNotFoundException;
import com.tracksnap.api.mapper.CompaniesMapper;
import com.tracksnap.api.repository.CompaniesRepository;
import com.tracksnap.api.service.CompaniesService;

@Service
public class CompaniesServiceImpl implements CompaniesService {

	private static Logger logger = LoggerFactory.getLogger(CompaniesServiceImpl.class);

	private CompaniesMapper companiesMapper;

	private CompaniesRepository companiesRepository;
	
	public CompaniesServiceImpl(CompaniesMapper companiesMapper, CompaniesRepository companiesRepository) {
		this.companiesMapper = companiesMapper;
		this.companiesRepository = companiesRepository;
	}

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

		if (companies.isEmpty()) {
			throw new ResourceNotFoundException("Companies not avalable " + companies.size());
		}
		List<CompaniesDTO> companiesDtos = companiesMapper.entityToDtoList(companies);
		
		writeCompaniesToCsv(companiesDtos);
		
		/* Sorting by CompanyId in descending order: */
		Collections.sort(companiesDtos, (company1, company2) -> Long.compare(company2.getCompanyId(), company1.getCompanyId()));
		return companiesDtos;
	}
	
	private void writeCompaniesToCsv(List<CompaniesDTO> companiesDtos) {
		try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/companies_data.csv"))) {
			String[] header = { "ID", "Name", "Email", "FoundedYear", "HeadquarterCity", "Phone", "Website",
					"FacebookUrl", "TwitterUrl", "LinkedInUrl", "InstagramUrl", "KM KeyMatricesId",
					"KM LatestFundingRound", "KM AnnualRevenue", "KM EmployeeCount"};
			writer.writeNext(header);
			for (CompaniesDTO companiesDto : companiesDtos) {
                String[] data = {
                		companiesDto.getCompanyId().toString(),
                		companiesDto.getName(),
                		companiesDto.getEmail(),
                		companiesDto.getFoundedYear()+"",
                		companiesDto.getHeadquarterCity(),
                		companiesDto.getPhone(),
                		companiesDto.getWebsite(),
                		companiesDto.getFacebookUrl(),
                		companiesDto.getTwitterUrl(),
                		companiesDto.getLinkedInUrl(),
                		companiesDto.getInstagramUrl(),
                		companiesDto.getKeyMatricesDTO().getKeyMatricesId().toString(),
                		companiesDto.getKeyMatricesDTO().getLatestFundingRound(),
                		companiesDto.getKeyMatricesDTO().getAnnualRevenue(),
                		companiesDto.getKeyMatricesDTO().getEmployeeCount()+""
                };
                writer.writeNext(data);
            }
			logger.info("CSV writing process completed successfully");
		} catch (Exception e) {
		}
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
		} catch (IOException ex) {
			logger.error("Exception occurred -> {}", ex.getMessage(), ex);
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
						() -> new ResourceNotFoundException("Companies is not exists with the given ID : " + companyId));

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
	
	@Override
	public void downloadLogoImageByCompanyId(Long companyId) {
		String home = System.getProperty("user.home");
		Path path = Paths.get(home, "downloads", "LogoImage.png");
		byte[] logoImageByteArr = companiesRepository.getLogoImageByCompanyId(companyId);
		try {
			if(logoImageByteArr != null) {
				Files.write(path, logoImageByteArr);
				logger.info("File has been downloaded...!");
			}
		} catch (Exception ex) {
			logger.error("Exception occurred -> {}", ex.getMessage(), ex);
		}
	}
	
	@Override
	public byte[] getLogoImageByCompanyId(Long companyId) {
		byte[] logoImageByteArr = companiesRepository.getLogoImageByCompanyId(companyId);
		
		Objects.requireNonNull(logoImageByteArr, "Logo Image is not exists with the given ID : " + companyId);
		
		return logoImageByteArr;
	}
	
}
