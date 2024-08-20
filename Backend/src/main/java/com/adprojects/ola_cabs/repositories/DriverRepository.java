package com.adprojects.ola_cabs.repositories;

import com.adprojects.ola_cabs.models.Driver;
import com.adprojects.ola_cabs.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    public Driver findByEmail(String email);

    @Query("SELECT R FROM Ride R WHERE R.status=REQUESTED AND R.driver.id=:driverId")
    public List<Ride> getAllocatedRides(@Param("driverId") Integer driverId);


    @Query("SELECT R FROM Ride R where R.status=COMPLETED AND R.driver.Id=:driverId")
    public List<Ride> getCompletedRides(@Param("driverId")Integer driverId);
}
