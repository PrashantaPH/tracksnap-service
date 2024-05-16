package com.tractsnap.api.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.tractsnap.api.dto.CompaniesDTO;
import com.tractsnap.api.entity.Companies;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompaniesMapper {

    CompaniesMapper INSTANCE = Mappers.getMapper(CompaniesMapper.class);

//    @Named("dtoToEntity")
    @Mapping(source = "companiesDTO.keyMatricesDTO", target = "keyMatrices")
    @Mapping(target = "logoImage", ignore = true)
    @Mapping(target = "countryFlagImage", ignore = true)
    Companies dtoToEntity(CompaniesDTO companiesDTO);

    @InheritInverseConfiguration(name = "dtoToEntity")
    @Mapping(target = "keyMatrices.keyMatricesId", ignore = false)
    CompaniesDTO entityToDto(Companies companies);
    
    List<CompaniesDTO> entityToDtoList(List<Companies> companies);
    
//    @Mapping(source = "companiesDTO.keyMatricesDTO", target = "keyMatrices")
//    @Mapping(target = "keyMatrices.keyMatricesId", ignore = true)
//    Companies dtoToEntityUpdate(@MappingTarget Companies companies, CompaniesDTO companiesDTO);
    
}

