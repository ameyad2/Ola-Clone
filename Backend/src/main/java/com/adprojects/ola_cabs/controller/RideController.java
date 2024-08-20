package com.adprojects.ola_cabs.controller;

import com.adprojects.ola_cabs.controller.mappers.DtoMapper;
import com.adprojects.ola_cabs.dtos.RideDTO;
import com.adprojects.ola_cabs.dtos.requests.RideRequest;
import com.adprojects.ola_cabs.dtos.requests.StartRideRequest;
import com.adprojects.ola_cabs.dtos.responses.MessageResponse;
import com.adprojects.ola_cabs.exceptions.DriverException;
import com.adprojects.ola_cabs.exceptions.RideException;
import com.adprojects.ola_cabs.exceptions.UserAlreadyExistsException;
import com.adprojects.ola_cabs.models.Driver;
import com.adprojects.ola_cabs.models.Ride;
import com.adprojects.ola_cabs.models.User;
import com.adprojects.ola_cabs.services.DriverService;
import com.adprojects.ola_cabs.services.RideService;
import com.adprojects.ola_cabs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private UserService userService;

    @Autowired
    private RideService rideService;

    @Autowired
    private DriverService driverService;

    @PostMapping("/request")
    public ResponseEntity<RideDTO> userRequestRideHandler(@RequestBody RideRequest rideRequest, @RequestHeader("Authorization") String jwt) throws UserAlreadyExistsException, DriverException {

        User user =userService.findUserByToken(jwt);

        Ride ride=rideService.requestRide(rideRequest, user);

        RideDTO rideDto= DtoMapper.toRideDto(ride);

        return new ResponseEntity<>(rideDto, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{rideId}/accept")
    public ResponseEntity<MessageResponse> acceptRideHandler(@PathVariable Integer rideId) throws UserAlreadyExistsException, RideException {

        rideService.acceptRide(rideId);

        MessageResponse res=new MessageResponse("Ride Accepted By Driver");

        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{rideId}/decline")
    public ResponseEntity<MessageResponse> declineRideHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer rideId)
            throws UserAlreadyExistsException, RideException, DriverException{

        Driver driver = driverService.getReqDriverProfile(jwt);

        rideService.declineRide(rideId, driver.getId());

        MessageResponse res=new MessageResponse("Ride decline By Driver");

        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{rideId}/start")
    public ResponseEntity<MessageResponse> rideStartHandler(@PathVariable Integer rideId, @RequestBody StartRideRequest req) throws UserAlreadyExistsException, RideException{

        rideService.startRide(rideId,req.getOtp());

        MessageResponse res=new MessageResponse("Ride is started");

        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{rideId}/complete")
    public ResponseEntity<MessageResponse> rideCompleteHandler(@PathVariable Integer rideId) throws UserAlreadyExistsException, RideException{

        rideService.completeRide(rideId);

        MessageResponse res=new MessageResponse("Ride Is Completed Thank You For Booking Cab");

        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{rideId}")
    public ResponseEntity<RideDTO> findRideByIdHandler(@PathVariable Integer rideId, @RequestHeader("Authorization") String jwt) throws UserAlreadyExistsException, RideException{

        User user =userService.findUserByToken(jwt);

        Ride ride =rideService.findRideById(rideId);


        RideDTO rideDto=DtoMapper.toRideDto(ride);


        return new ResponseEntity<RideDTO>(rideDto,HttpStatus.ACCEPTED);
    }
}
