package com.tractsnap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tractsnap.api.entity.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Long>{

}
