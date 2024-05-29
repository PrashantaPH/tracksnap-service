package com.tracksnap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tracksnap.api.entity.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Long>{
	
	@Query("SELECT c.logoImage FROM Companies c WHERE c.companyId = ?1")
	byte[] getLogoImageByCompanyId(@Param("companyId") Long companyId);

}
