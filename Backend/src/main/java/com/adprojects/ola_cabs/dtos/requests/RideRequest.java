package com.adprojects.ola_cabs.dtos.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideRequest {

    private double pickUpLatitude;
    private double pickUpLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private String pickUpArea;
    private String destinationArea;
}
