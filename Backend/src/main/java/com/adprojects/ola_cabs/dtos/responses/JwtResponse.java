package com.adprojects.ola_cabs.dtos.responses;

import com.adprojects.ola_cabs.models.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String jwt;
    private String message;
    private boolean isAuthenticated;
    private boolean isError;
    private String errorDetails;
    private UserRole type;
}
