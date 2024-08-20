package com.adprojects.ola_cabs.controller.mappers;

import com.adprojects.ola_cabs.dtos.DriverDTO;
import com.adprojects.ola_cabs.dtos.RideDTO;
import com.adprojects.ola_cabs.dtos.UserDTO;
import com.adprojects.ola_cabs.models.Driver;
import com.adprojects.ola_cabs.models.Ride;
import com.adprojects.ola_cabs.models.User;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper {

    public static DriverDTO toDriverDto(Driver driver){

        DriverDTO driverDto=new DriverDTO();

        driverDto.setEmail(driver.getEmail());
        driverDto.setId(driver.getId());
        driverDto.setLatitude(driver.getLatitude());
        driverDto.setLongitude(driver.getLongitude());
        driverDto.setMobile(driver.getMobile());
        driverDto.setName(driver.getName());
        driverDto.setRating(driver.getRating());
        driverDto.setRole(driver.getRole());
        driverDto.setVehicle(driver.getVehicle());


        return driverDto;

    }
    public static UserDTO toUserDto(User user) {

        UserDTO userDto=new UserDTO();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setMobile(user.getMobile());
        userDto.setName(user.getFullName());

        return userDto;

    }

    public static RideDTO toRideDto(Ride ride) {
        DriverDTO driverDTO=toDriverDto(ride.getDriver());
        UserDTO userDto=toUserDto(ride.getUser());

        RideDTO rideDto=new RideDTO();

        rideDto.setDestinationLatitude(ride.getDestinationLatitude());
        rideDto.setDestinationLongitude(ride.getDestinationLongitude());
        rideDto.setDistance(ride.getDistance());
        rideDto.setDriver(driverDTO);
        rideDto.setDuration(ride.getDuration());
        rideDto.setEndTime(ride.getEndTime());
        rideDto.setFare(ride.getFare());
        rideDto.setId(ride.getId());
        rideDto.setPickupLatitude(ride.getPickUpLatitude());
        rideDto.setPickupLongitude(ride.getPickUpLongitude());
        rideDto.setStartTime(ride.getStartTime());
        rideDto.setStatus(ride.getStatus());
        rideDto.setUser(userDto);
        rideDto.setPickupArea(ride.getPickUpArea());
        rideDto.setDestinationArea(ride.getDestinationArea());
        rideDto.setPaymentDetails(ride.getPaymentDetails());
        rideDto.setOtp(ride.getOtp());
        return rideDto;
    }
}
