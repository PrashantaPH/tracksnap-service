package com.tracksnap.api.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.tracksnap.api.dto.AboutCompanyDTO;
import com.tracksnap.api.dto.CompaniesDTO;
import com.tracksnap.api.dto.KeyMatricesDTO;
import com.tracksnap.api.dto.PeopleDTO;
import com.tracksnap.api.dto.ReportsDTO;
import com.tracksnap.api.dto.RevenueDTO;
import com.tracksnap.api.dto.SearchCompaniesResponse;
import com.tracksnap.api.dto.SectorsDTO;
import com.tracksnap.api.entity.AboutCompany;
import com.tracksnap.api.entity.Companies;
import com.tracksnap.api.entity.KeyMatrices;
import com.tracksnap.api.entity.People;
import com.tracksnap.api.entity.Reports;
import com.tracksnap.api.entity.Revenue;
import com.tracksnap.api.entity.Sectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompaniesMapper {

	CompaniesMapper INSTANCE = Mappers.getMapper(CompaniesMapper.class);

//    @Named("dtoToEntity")
	@Mapping(source = "companiesDTO.keyMatricesDTO", target = "keyMatrices")
	@Mapping(source = "companiesDTO.aboutCompanyDTO", target = "aboutCompany")
	@Mapping(source = "companiesDTO.sectorsDTO", target = "sectors")
	@Mapping(source = "companiesDTO.peopleDTO", target = "people")
	@Mapping(source = "companiesDTO.revenueDTO", target = "revenue")
	@Mapping(source = "companiesDTO.reportsDTO", target = "reports")
	@Mapping(target = "createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "keyMatrices.createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "aboutCompany.createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "sectors.createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "people.createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "revenue.createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "reports.createdAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	Companies dtoToEntity(CompaniesDTO companiesDTO);

	@InheritInverseConfiguration(name = "dtoToEntity")
	CompaniesDTO entityToDto(Companies companies);

	List<CompaniesDTO> entityToDtoList(List<Companies> companies);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "companyId", ignore = true)
	void updateCompanyFromDto(CompaniesDTO dto, @MappingTarget Companies entity);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "keyMatricesId", ignore = true)
	void updateKeyMatricesFromDto(KeyMatricesDTO dto, @MappingTarget KeyMatrices entity);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "aboutComapnyId", ignore = true)
	void updateAboutCompanyFromDto(AboutCompanyDTO dto, @MappingTarget AboutCompany entity);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "sectorsId", ignore = true)
	void updateSectorsFromDto(SectorsDTO dto, @MappingTarget Sectors entity);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "countId", ignore = true)
	void updatePeopleFromDto(PeopleDTO dto, @MappingTarget People entity);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "revenueId", ignore = true)
	void updateRevenueFromDto(RevenueDTO dto, @MappingTarget Revenue entity);

	@Mapping(target = "updatedAt", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
	@Mapping(target = "reportId", ignore = true)
	void updateReportsFromDto(ReportsDTO dto, @MappingTarget Reports entity);
	
	List<SearchCompaniesResponse> entityToSearchCompaniesResponse(List<Companies> companiesList);

}
