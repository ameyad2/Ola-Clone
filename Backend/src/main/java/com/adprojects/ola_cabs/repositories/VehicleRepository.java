package com.adprojects.ola_cabs.repositories;

import com.adprojects.ola_cabs.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
