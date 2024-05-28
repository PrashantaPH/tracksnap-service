package com.tracksnap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracksnap.api.entity.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Long>{

}
