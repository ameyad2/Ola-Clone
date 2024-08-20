package com.adprojects.ola_cabs.dtos;

import com.adprojects.ola_cabs.models.PaymentDetails;
import com.adprojects.ola_cabs.models.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideDTO {

    private Integer id;
    private UserDTO user;
    private DriverDTO driver;
    private double pickupLatitude;
    private double pickupLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private String pickupArea;
    private String destinationArea;
    private double distance;
    private long duration;
    private RideStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double fare;
    private PaymentDetails paymentDetails;
    private int otp;
}
