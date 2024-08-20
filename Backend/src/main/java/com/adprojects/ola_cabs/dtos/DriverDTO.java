package com.adprojects.ola_cabs.dtos;


import com.adprojects.ola_cabs.models.Vehicle;
import com.adprojects.ola_cabs.models.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDTO {

    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private double rating;
    private double latitude;
    private double longitude;
    private UserRole role;
    private Vehicle vehicle;


}
