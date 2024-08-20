package com.adprojects.ola_cabs.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequest {

    @NotBlank(message= "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private String fullName;
    private String password;
    private String mobile;
}
