package com.adprojects.ola_cabs.models;

import com.adprojects.ola_cabs.models.enums.RideStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;

    @JsonIgnore
    private List<Integer> declinedDrivers = new ArrayList<>();

    private double pickUpLatitude;
    private double pickUpLongitude;
    private double destinationLatitude;
    private double destinationLongitude;

    private String pickUpArea;
    private String destinationArea;
    private double distance;
    private long duration;
    private RideStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double fare;
    private int otp;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();


}
