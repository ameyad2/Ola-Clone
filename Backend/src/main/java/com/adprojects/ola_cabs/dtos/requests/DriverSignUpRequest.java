package com.adprojects.ola_cabs.dtos.requests;

import com.adprojects.ola_cabs.models.License;
import com.adprojects.ola_cabs.models.Vehicle;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverSignUpRequest {

    private String name;
    private String email;
    private String mobile;
    private String password;
    private double latitude;
    private double longitude;
    private License license;
    private Vehicle vehicle;

}
