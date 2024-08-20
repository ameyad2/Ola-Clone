package com.adprojects.ola_cabs.dtos.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StartRideRequest {

    private int otp;
}
