package com.adprojects.ola_cabs.services;

import com.adprojects.ola_cabs.dtos.requests.RideRequest;
import com.adprojects.ola_cabs.exceptions.DriverException;
import com.adprojects.ola_cabs.exceptions.RideException;
import com.adprojects.ola_cabs.models.Driver;
import com.adprojects.ola_cabs.models.Ride;
import com.adprojects.ola_cabs.models.User;

public interface RideService {


    public Ride requestRide(RideRequest rideRequest, User user) throws DriverException;

    public Ride createRideRequest(User user, Driver nearesDriver,
                                  double picupLatitude, double pickupLongitude,
                                  double destinationLatitude, double destinationLongitude,
                                  String pickupArea, String destinationArea);

    public void acceptRide(Integer rideId) throws RideException;

    public void declineRide(Integer rideId, Integer driverId) throws RideException;

    public void startRide(Integer rideId,int opt) throws RideException;

    public void completeRide(Integer rideId) throws RideException;

    public void cancleRide(Integer rideId) throws RideException;

    public Ride findRideById(Integer rideId) throws RideException;
}
