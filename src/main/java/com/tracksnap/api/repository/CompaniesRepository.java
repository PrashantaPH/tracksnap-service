package com.tracksnap.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tracksnap.api.entity.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Long>{
	
	@Query("SELECT c.logoImage FROM Companies c WHERE c.companyId = ?1")
	byte[] getLogoImageByCompanyId(@Param("companyId") Long companyId);
	
	@Query("SELECT count(*) FROM Companies")
	Long countOfRecords();

	@Query("SELECT companyId FROM Companies")
	List<Long> getAllCompanyId();
	
//	@Query("SELECT c FROM Companies c WHERE c.name LIKE ?1%")
//	List<Companies> searchComapanyName(@Param("name") String name);
//	OR
	List<Companies> findByNameStartsWith(String name); // Hibernate will take care the above query
	
	@Query("SELECT new com.tracksnap.api.entity.Companies(c.companyId, c.name, c.foundedYear,"
			+ " c.headquarterCity, c.logoImage) FROM Companies c WHERE c.name LIKE ?1%")
	List<Companies> searchByName(@Param("name") String name);

}
