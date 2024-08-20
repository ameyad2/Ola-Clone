package com.adprojects.ola_cabs.repositories;

import com.adprojects.ola_cabs.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Integer> {
}
