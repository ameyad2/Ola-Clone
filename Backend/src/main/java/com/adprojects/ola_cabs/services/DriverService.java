package com.adprojects.ola_cabs.services;

import com.adprojects.ola_cabs.dtos.requests.DriverSignUpRequest;
import com.adprojects.ola_cabs.exceptions.DriverException;
import com.adprojects.ola_cabs.models.Driver;
import com.adprojects.ola_cabs.models.Ride;

import java.util.List;

public interface DriverService {

    public Driver registerDriver(DriverSignUpRequest driverSignupRequest);

    public List<Driver> getAvailableDrivers(double pickupLatitude,
                                            double picupLongitude, double radius, Ride ride);

    public Driver findNearestDriver(List<Driver> availableDrivers,
                                    double picupLatitude, double picupLongitude);

    public Driver getReqDriverProfile(String jwt) throws DriverException;

    public Ride getDriversCurrentRide(Integer driverId) throws DriverException;

    public List<Ride> getAllocatedRides(Integer driverId) throws DriverException;

    public Driver findDriverById(Integer driverId) throws DriverException;

    public List<Ride> completedRids(Integer driverId) throws DriverException;


}
